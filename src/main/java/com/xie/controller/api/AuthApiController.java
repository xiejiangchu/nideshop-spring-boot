package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.xie.bean.User;
import com.xie.bean.WxSession;
import com.xie.config.MyWxPayConfig;
import com.xie.request.LoginRequest;
import com.xie.response.BaseResponse;
import com.xie.response.TokenResponse;
import com.xie.service.UserService;
import com.xie.utils.AES;
import com.xie.utils.MallConstants;
import com.xie.utils.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xie on 17/8/24.
 */
@Controller
@RequestMapping(value = "/api/auth")
public class AuthApiController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthApiController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AES aes;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    BaseResponse index() {
        return BaseResponse.ok("auth");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse login(@RequestBody LoginRequest loginRequest, HttpSession session) {


        Map<String, String> vars = new HashMap<String, String>();
        vars.put("appId", MyWxPayConfig.getAppId());
        vars.put("appSecret", MyWxPayConfig.getAppSecret());
        vars.put("js_code", loginRequest.getCode());
        ResponseEntity<String> result = restTemplate.exchange("https://api.weixin.qq.com/sns/jscode2session?appid={appId}&secret={appSecret}&js_code={js_code}&grant_type=authorization_code", HttpMethod.GET, null, String.class, vars);
        if (result != null && result.getBody() != null) {
            WxSession wxSession = JSONObject.parseObject(result.getBody(), WxSession.class);
            User user_cache = (User) cacheManager.getCache(MallConstants.CACHE_NAME).get(MallConstants.SESSION_USER + wxSession.getOpenid());
            if (user_cache != null) {
                TokenResponse tokenResponse = new TokenResponse();
                session.setAttribute(MallConstants.SESSION_USER, user_cache);
                tokenResponse.setUserInfo(user_cache);
                return BaseResponse.ok(tokenResponse);
            }
            User user = userService.getByOpenId(wxSession.getOpenid());
            String token = StringUtils.generateToken();
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            if (user != null) {
                BeanUtils.copyProperties(loginRequest.getUserInfo().getUserInfo(), user);
                user.setOpenid(wxSession.getOpenid());
                user.setWx(loginRequest.getUserInfo().getUserInfo().getNickName());
                user.setToken(token);
                userService.updateAll(user);
                session.setAttribute(MallConstants.SESSION_USER, user);
                tokenResponse.setUserInfo(user);
                cacheManager.getCache(MallConstants.CACHE_NAME).put(MallConstants.SESSION_USER + wxSession.getOpenid(), user);
                return BaseResponse.ok(tokenResponse);
            } else {
                if (null != wxSession.getSession_key()) {
                    User insert = new User();
                    BeanUtils.copyProperties(loginRequest.getUserInfo().getUserInfo(), insert);
                    insert.setOpenid(wxSession.getOpenid());
                    insert.setWx(loginRequest.getUserInfo().getUserInfo().getNickName());
                    insert.setToken(token);
                    insert.setCreatedAt(DateTime.now().toDate());
                    insert.setUpdatedAt(DateTime.now().toDate());
                    insert.setUserLevelId((byte) 0);
                    insert.setPassword(bCryptPasswordEncoder.encode("pass@1234"));
                    int uid = userService.insert(insert);
                    if (uid > 0) {
                        User user_new = userService.getById(uid);
                        session.setAttribute(MallConstants.SESSION_USER, user_new);
                        tokenResponse.setUserInfo(user_new);
                        cacheManager.getCache(MallConstants.CACHE_NAME).put(MallConstants.SESSION_USER + wxSession.getOpenid(), user_new);
                        return BaseResponse.ok(tokenResponse);
                    } else {
                        return BaseResponse.fail();
                    }

                }
                return BaseResponse.ok(tokenResponse);
            }
        }

        return BaseResponse.ok();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse logout() {
        return BaseResponse.ok();
    }
}
