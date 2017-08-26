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
@RequestMapping(value = "/api/user")
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
}
