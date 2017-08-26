package com.xie.request;

/**
 * Created by xie on 17/8/26.
 */
public class LoginRequest {


    /**
     * code : 0717q9VO0N4On92jzcWO0BCkVO07q9VP
     * encryptedData : L564bR+1XIlqnbkPZy3lUdiyoCUZWEe5QeWkAx2/SFphBwsa9P/rZpI02Z0WlqJOfvTcVqeKFwzy3x25R0qkkVzSKa1U0S2M7xgduYbU5YnSjwal6m9rbDO6aMMfCdIukdJnFbOXfBBAXOtBqSZFXWtSYUGhuAw4i5eilmIwDD268/3ii4RsZ07Tth0yOChhewxqIV9raKxSes/45d03d4yb/4X3Ne5usUGozj81xjv21Vm+9NCGD34TSJly6W0WkEG27tA+d6VOZ3gYOKLcfncEFmBz+F0omfRT3QJBKoU94LuYwm5/+quUa3lgb6SPS1+crj3AIKEveHbCOOBWpbfjN4PZIT2Hv1ObFrjnhTKElr1rHcZgDryugdEpQ3Do+S9FTbeV2TBQymUHlVMTsegWLUQsBYvo5yJQW0uq1wryulvKIVRvOcrCIOpHpZheneAFVP2GQJ7b5OqJkYa7hXBXHATD2VGjPnq9KLwyrU4=
     * iv : rg1PZYSKDAko2Ej2Px8FcQ==
     * userInfo : {"nickName":"谢江初","gender":1,"language":"zh_CN","city":"Yichun","province":"Jiangxi","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/sLtlIY9icQo2bEb8gd7kkaZgjdWPn8bLMkrf9HLsfeAaZm39dkme8UjrBrCicZPNhLamuibSIm8OkVjlOscIJic0yFkF6EDic76ia2/0"}
     */

    private String code;
    private UserInfoBean userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * nickName : 谢江初
         * gender : 1
         * language : zh_CN
         * city : Yichun
         * province : Jiangxi
         * country : China
         * avatarUrl : https://wx.qlogo.cn/mmopen/sLtlIY9icQo2bEb8gd7kkaZgjdWPn8bLMkrf9HLsfeAaZm39dkme8UjrBrCicZPNhLamuibSIm8OkVjlOscIJic0yFkF6EDic76ia2/0
         */

        private String nickName;
        private int gender;
        private String language;
        private String city;
        private String province;
        private String country;
        private String avatarUrl;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }
}
