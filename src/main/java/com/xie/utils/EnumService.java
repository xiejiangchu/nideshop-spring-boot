package com.xie.utils;

import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/9/1.
 */
@Service("enumService")
public class EnumService {

    public String getAdPositionType(int val) {
        MallConstants.AdPositionType[] list = MallConstants.AdPositionType.values();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getVal() == val) {
                return list[i].name();
            }
        }
        return "";
    }


    public String getMediaType(int val) {
        MallConstants.MediaType[] list = MallConstants.MediaType.values();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getVal() == val) {
                return list[i].name();
            }
        }
        return "";
    }

    public String getInputType(int val) {
        MallConstants.InputType[] list = MallConstants.InputType.values();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getVal() == val) {
                return list[i].name();
            }
        }
        return "";
    }
}
