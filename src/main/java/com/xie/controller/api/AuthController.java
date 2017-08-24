package com.xie.controller.api;

import com.alibaba.fastjson.JSON;
import com.xie.bean.User;
import com.xie.bean.WxSession;
import com.xie.bean.WxUser;
import com.xie.config.MyWxPayConfig;
import com.xie.response.BaseResponse;
import com.xie.response.SessionResponse;
import com.xie.service.UserService;
import com.xie.utils.AES;
import com.xie.utils.MallConstants;
import com.xie.utils.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xie on 17/8/24.
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AES aes;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    BaseResponse index() {
        return BaseResponse.ok("auth");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse login(@RequestParam("code") String code,
                       @RequestParam("encryptedData") String encryptedData,
                       @RequestParam("iv") String iv, HttpSession session) {

        Map<String, String> vars = new HashMap<String, String>();
        vars.put("appId", MyWxPayConfig.getAppId());
        vars.put("appSecret", MyWxPayConfig.getAppSecret());
        vars.put("js_code", code);
        ResponseEntity<WxSession> result = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid={appId}&secret={appSecret}&js_code={js_code}&grant_type=authorization_code", WxSession.class, vars);
        if (result != null && result.getBody() != null) {
            WxSession wxSession = result.getBody();
            User user = userService.getByOpenId(wxSession.getOpenid());
            String sessionId = StringUtils.generateSessionId();
            SessionResponse sessionResponse = new SessionResponse();
            sessionResponse.setSessionId(sessionId);
            if (user != null) {
                user.setRegisterTime((int) DateTime.now().toDate().getTime());
                userService.updateAll(user);
                session.setAttribute(MallConstants.SESSION_USER, user);
                sessionResponse.setUid(user.getId());
                return BaseResponse.ok(sessionResponse);
            } else {
                if (null != wxSession.getSession_key()) {
                    byte[] resultByte = new byte[0];
                    try {
                        resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(wxSession.getSession_key()), Base64.decodeBase64(iv));
                    } catch (InvalidAlgorithmParameterException e) {
                        logger.error("Base64错误");
                    }
                    if (null != resultByte && resultByte.length > 0) {
                        WxUser wxUser = null;
                        try {
                            wxUser = JSON.parseObject(new String(resultByte, "UTF-8"), WxUser.class);
                        } catch (UnsupportedEncodingException e) {
                            logger.error("UnsupportedEncodingException 错误");
                        }
                        User insert = new User();
                        BeanUtils.copyProperties(wxUser, insert);
                        insert.setLastLoginTime((int) DateTime.now().toDate().getTime());

                        User checkExisted = userService.getByOpenId(insert.getWeixinOpenid());
                        int uid = -1;
                        if (checkExisted != null) {
                            uid = checkExisted.getId();
                            userService.updateAll(insert);
                        } else {
                            insert.setUsername(wxUser.getNickName());
                            insert.setPassword(bCryptPasswordEncoder.encode("pass@1234"));
                            uid = userService.insertAll(insert);
                            user = userService.getById(uid);
                            session.setAttribute(MallConstants.SESSION_USER, user);
                            sessionResponse.setUid(uid);
                        }
                    }
                    return BaseResponse.ok(sessionResponse);
                } else {
                    logger.error("微信appKey,appSecret错误");
                }

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
