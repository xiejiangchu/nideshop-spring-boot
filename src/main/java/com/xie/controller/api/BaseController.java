package com.xie.controller.api;

import com.xie.auth.MyUserDetails;
import com.xie.bean.User;
import com.xie.response.BaseResponse;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xie
 * @Date 17/2/23 下午12:46.
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication instanceof UsernamePasswordAuthenticationToken) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            return myUserDetails.getUser();
        }
        return null;
    }

    public int getUid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication instanceof UsernamePasswordAuthenticationToken) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            return myUserDetails.getUser().getId();
        }
        return 1;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    private BaseResponse exceptionHandler(IllegalArgumentException exception) {
        return BaseResponse.fail(exception.getMessage());
    }
}
