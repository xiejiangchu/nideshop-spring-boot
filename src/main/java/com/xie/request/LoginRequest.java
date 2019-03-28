package com.xie.request;

/**
 * Created by xie on 17/8/26.
 */
public class LoginRequest {


    /**
     * code : 021HuvdZ0OkcKV1RVHdZ07DydZ0HuvdE
     * userInfo : {"errMsg":"getUserInfo:ok","rawData":"{\"nickName\":\"谢江初\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Yichun\",\"province\":\"Jiangxi\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOZvian7BRRNhFbMzUn5CMBgWiaOdh09LCq8icYWLD7AUMu9mxiazaqUgrDeia1DyXLrjA81iajouG6yXw/132\"}","signature":"59d43f7d20b64be8b629db4c31a8939449129c9b","encryptedData":"FLdCVMh0zCOB2mlAnJQDsaBS9oX6cV4sIRM2lNA4yBtz5TCiHCtV+blkQj6BEiv2q53IT3HZ8+SCiFSQowfEEJcSvUCHwtSRHEGqFSU7TPcG41wbTGNOiStdOIW+Zwj3D3K8kL7zfCo3bYTjnF6VMcLVe9K0+NpdPziTr+AYw6vkK267OG0zfJ31yj6KAqrz0ND0V/KP7BsMrlm0cH50qVmgi75ERw06oa8WYB5CThAbJXuABiLkbL6iYND8XqoBb0bRbgf5JYu40veYz8uy59T6CkSFI5Vt2/rL4WDUbyCZ8Y49mvNvWOujWEIo22DVsh+tZ5pO3DvAZrHISSb+fH1BhakdF5xCMiq1kUvkh7FVMs6ZAfaKJEZtq1cRPv/B4y1LHrMPzHpy0vEOaQ4oFy7dk+cRhohR/YDg3H7FL3x6ZXrbvAbnH0+7Jpx/2FdyFQQwoSe3pWTRugOQyddSG1GRt8VzoKOrNI/SaBmdLgE=","iv":"oD66zxnf7gUdNuHuAoB80A==","userInfo":{"nickName":"谢江初","gender":1,"language":"zh_CN","city":"Yichun","province":"Jiangxi","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOZvian7BRRNhFbMzUn5CMBgWiaOdh09LCq8icYWLD7AUMu9mxiazaqUgrDeia1DyXLrjA81iajouG6yXw/132"}}
     */

    private String code;
    private UserInfoBeanX userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfoBeanX getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBeanX userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBeanX {
        /**
         * errMsg : getUserInfo:ok
         * rawData : {"nickName":"谢江初","gender":1,"language":"zh_CN","city":"Yichun","province":"Jiangxi","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOZvian7BRRNhFbMzUn5CMBgWiaOdh09LCq8icYWLD7AUMu9mxiazaqUgrDeia1DyXLrjA81iajouG6yXw/132"}
         * signature : 59d43f7d20b64be8b629db4c31a8939449129c9b
         * encryptedData : FLdCVMh0zCOB2mlAnJQDsaBS9oX6cV4sIRM2lNA4yBtz5TCiHCtV+blkQj6BEiv2q53IT3HZ8+SCiFSQowfEEJcSvUCHwtSRHEGqFSU7TPcG41wbTGNOiStdOIW+Zwj3D3K8kL7zfCo3bYTjnF6VMcLVe9K0+NpdPziTr+AYw6vkK267OG0zfJ31yj6KAqrz0ND0V/KP7BsMrlm0cH50qVmgi75ERw06oa8WYB5CThAbJXuABiLkbL6iYND8XqoBb0bRbgf5JYu40veYz8uy59T6CkSFI5Vt2/rL4WDUbyCZ8Y49mvNvWOujWEIo22DVsh+tZ5pO3DvAZrHISSb+fH1BhakdF5xCMiq1kUvkh7FVMs6ZAfaKJEZtq1cRPv/B4y1LHrMPzHpy0vEOaQ4oFy7dk+cRhohR/YDg3H7FL3x6ZXrbvAbnH0+7Jpx/2FdyFQQwoSe3pWTRugOQyddSG1GRt8VzoKOrNI/SaBmdLgE=
         * iv : oD66zxnf7gUdNuHuAoB80A==
         * userInfo : {"nickName":"谢江初","gender":1,"language":"zh_CN","city":"Yichun","province":"Jiangxi","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOZvian7BRRNhFbMzUn5CMBgWiaOdh09LCq8icYWLD7AUMu9mxiazaqUgrDeia1DyXLrjA81iajouG6yXw/132"}
         */

        private String errMsg;
        private String rawData;
        private String signature;
        private String encryptedData;
        private String iv;
        private UserInfoBean userInfo;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getRawData() {
            return rawData;
        }

        public void setRawData(String rawData) {
            this.rawData = rawData;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getEncryptedData() {
            return encryptedData;
        }

        public void setEncryptedData(String encryptedData) {
            this.encryptedData = encryptedData;
        }

        public String getIv() {
            return iv;
        }

        public void setIv(String iv) {
            this.iv = iv;
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
             * avatarUrl : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOZvian7BRRNhFbMzUn5CMBgWiaOdh09LCq8icYWLD7AUMu9mxiazaqUgrDeia1DyXLrjA81iajouG6yXw/132
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
}
