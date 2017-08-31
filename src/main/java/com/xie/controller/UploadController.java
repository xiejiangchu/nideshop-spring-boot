package com.xie.controller;

import com.alibaba.media.upload.UploadPolicy;
import com.alibaba.media.upload.UploadTokenClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author xie
 * @Date 17/2/23 下午4:33.
 */
@Controller
public class UploadController {

    @Autowired
    private UploadTokenClient uploadTokenClient;

    @Autowired
    private UploadPolicy uploadPolicy;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String index(Model model) {
        String token = uploadTokenClient.getUploadToken(uploadPolicy);
        model.addAttribute("token", token);
        return "upload";
    }
}
