package com.xie.service.impl;

import com.alibaba.media.upload.UploadPolicy;
import com.alibaba.media.upload.UploadTokenClient;
import com.xie.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/31.
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadTokenClient uploadTokenClient;

    @Autowired
    private UploadPolicy uploadPolicy;

    @Override
    public String token() {
        return null;
    }
}
