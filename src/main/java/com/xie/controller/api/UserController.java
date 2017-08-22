package com.xie.controller.api;

import com.xie.response.BaseResponse;
import com.xie.service.UserService;
import com.xie.utils.AES;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 16/11/24.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @Autowired
    private AES aes;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUser(@PathVariable("id") int id) {
        return BaseResponse.ok(userService.getById(id));
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize(value = "hasRole('ROLE_admin')")
    BaseResponse getAllUser(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return BaseResponse.ok(userService.getAllUsers(pageNum, pageSize));
    }


//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    @ResponseBody
//    public BaseResponse postUser(@ModelAttribute User user) {
//        userService.insert(user);
//        return BaseResponse.ok();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public BaseResponse putUser(@PathVariable int id, @ModelAttribute User user) {
//        int result = userService.update(user);
//        if (result > 0) {
//            return BaseResponse.ok();
//        } else {
//            return BaseResponse.fail();
//        }
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public BaseResponse deleteUser(@PathVariable int id) {
//        int result = userService.softDelete(id);
//        if (result > 0) {
//            return BaseResponse.ok();
//        } else {
//            return BaseResponse.fail();
//        }
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public BaseResponse login(@RequestParam("sessionId") String sessionId, HttpSession session) {
//        System.out.println("hit");
//        User user = userService.getBySessionId(sessionId);
//        if (null == user) {
//            return BaseResponse.fail();
//        }
//        SessionResponse sessionResponse = new SessionResponse();
//        sessionResponse.setUid(user.getId());
//        sessionResponse.setSessionId(sessionId);
//        session.setAttribute(MallConstants.SESSION_USER, user);
//        return BaseResponse.ok(sessionResponse);
//    }
//
//    @RequestMapping(value = "/get3rdSession", method = RequestMethod.GET)
//    @ResponseBody
//    public BaseResponse get3rdSession(@RequestParam("code") String code,
//                                      @RequestParam("encryptedData") String encryptedData,
//                                      @RequestParam("iv") String iv, HttpSession session) {
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + MyWxPayConfig.getAppId() + "&secret=" + MyWxPayConfig.getAppSecret() + "&js_code=" + code + "&grant_type=authorization_code";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        try {
//            HttpGet get = new HttpGet(url);
//            CloseableHttpResponse httpResponse = httpClient.execute(get);
//            try {
//                HttpEntity entity = httpResponse.getEntity();
//                if (null != entity) {
//                    String result = EntityUtils.toString(entity);
//                    WxSession wxSession = JSON.parseObject(result, WxSession.class);
//                    User user = userService.getByOpenId(wxSession.getOpenid());
//                    String sessionId = StringUtils.generateSessionId();
//                    SessionResponse sessionResponse = new SessionResponse();
//                    sessionResponse.setSessionId(sessionId);
//                    if (user != null) {
//                        user.setSessionId(sessionId);
//                        user.setExpired(DateTime.now().plusDays(30).toDate());
//                        userService.updateAll(user);
//                        session.setAttribute(MallConstants.SESSION_USER, user);
//                        sessionResponse.setUid(user.getId());
//                        return BaseResponse.ok(sessionResponse);
//                    } else {
//                        if (null != wxSession.getSession_key()) {
//                            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(wxSession.getSession_key()), Base64.decodeBase64(iv));
//                            if (null != resultByte && resultByte.length > 0) {
//                                WxUser wxUser = JSON.parseObject(new String(resultByte, "UTF-8"), WxUser.class);
//                                User insert = new User();
//                                BeanUtils.copyProperties(wxUser, insert);
//                                insert.setSessionId(sessionId);
//                                insert.setExpired(DateTime.now().plusDays(30).toDate());
//
//                                User checkExisted = userService.getByOpenId(insert.getOpenId());
//                                int uid = -1;
//                                if (checkExisted != null) {
//                                    uid = checkExisted.getId();
//                                    userService.updateAll(insert);
//                                } else {
//                                    insert.setName(wxUser.getNickName());
//                                    insert.setEnabled(1);
//                                    insert.setVerified(1);
//                                    insert.setPassword(bCryptPasswordEncoder.encode("pass@1234"));
//                                    uid = userService.insertAll(insert);
//                                    user = userService.getById(uid);
//                                    session.setAttribute(MallConstants.SESSION_USER, user);
//                                    sessionResponse.setUid(uid);
//                                    //积分初始化
//                                    Point point = new Point();
//                                    point.setUid(uid);
//                                    point.setMoney(0);
//                                    point.setPoints(0);
//                                    pointService.insert(point);
//                                }
//                            }
//                            return BaseResponse.ok(sessionResponse);
//                        } else {
//                            logger.error("微信appKey,appSecret错误");
//                        }
//
//                    }
//                }
//            } finally {
//                httpResponse.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return BaseResponse.ok();
//    }
}
