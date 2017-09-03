package com.xie.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author xie
 * @Date 17/3/4 上午11:00.
 */
public class MallConstants {

    public final static String CNAREA_ROOT = "江西省";

    public final static int PAGESIZE = 10;
    public final static String SESSION_USER = "SESSION_USER";
    public final static String COOKIE_UID = "COOKIE_UID";
    public final static String PAYMENT_CASH = "货到付款";
    public final static int POINT_RATE = 100;
    public final static int ERROR_CODE = -1;

    public final static String ADMIN = "admin";

    public final static String SESSION_ID = "sessionId";
    public final static String SYS_QUESTIONS = "questions";
    public final static String SYS_ABOUT = "about";
    public final static String SYS_NOTICE = "notice";

    public final static double ORDER_MIN_MONEY = 20;


    public final static int YES = 1;
    public final static int NO = 0;

    public final static int ERROR_POINT_NOT_ENOUGH = 80000;
    public final static int ERROR_LT_ORDER_MIN_MONEY = 80001;
    public final static int ERROR_ITEM_CHANGED = 1;

    public final static String CACHE_NAME = "GUAVA_CACHE_NAME_1";

    public enum AdPositionType {
        首页标题(1), 购物车(2);
        private int val;

        AdPositionType(int val) {
            this.val = val;
        }

        public static JSONArray json() {
            JSONArray jsonArray = new JSONArray();
            AdPositionType[] list = AdPositionType.values();
            for (int i = 0; i < list.length; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", list[i].name());
                jsonObject.put("val", list[i].val);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public enum MediaType {
        链接(1), 商品(2), 富文本(3);
        private int val;

        MediaType(int val) {
            this.val = val;
        }

        public static JSONArray json() {
            JSONArray jsonArray = new JSONArray();
            MediaType[] list = MediaType.values();
            for (int i = 0; i < list.length; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", list[i].name());
                jsonObject.put("val", list[i].val);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public enum InputType {
        文本(1), 富文本(2);
        private int val;

        InputType(int val) {
            this.val = val;
        }

        public static JSONArray json() {
            JSONArray jsonArray = new JSONArray();
            InputType[] list = InputType.values();
            for (int i = 0; i < list.length; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", list[i].name());
                jsonObject.put("val", list[i].val);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }


    public enum CollectType {
        商品(0);
        private int val;

        CollectType(int val) {
            this.val = val;
        }

        public static JSONArray json() {
            JSONArray jsonArray = new JSONArray();
            CollectType[] list = CollectType.values();
            for (int i = 0; i < list.length; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", list[i].name());
                jsonObject.put("val", list[i].val);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
