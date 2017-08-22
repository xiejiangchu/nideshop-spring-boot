package com.xie.config;

import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by xie on 17/5/1.
 */
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationContextListener.class);

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext() instanceof AnnotationConfigEmbeddedWebApplicationContext) {
//            logger.info("开始创建菜单");
//            //创建菜单
//            //创建一级菜单
//            WxMenuButton button1 = new WxMenuButton();
//            button1.setType("click"); //点击事件按钮
//            button1.setName("点击菜单");
//            button1.setKey("key1"); //根据标志获取点击菜单
//
//            //创建一个复合菜单
//            WxMenuButton button2 = new WxMenuButton();
//            button2.setName("多级菜单");
//
//            WxMenuButton button2_1 = new WxMenuButton();
//            button2_1.setType("click"); //点击事件按钮
//            button2_1.setName("子菜单一");
//            button2_1.setKey("key2"); //根据标志获取点击菜单
//
//            WxMenuButton button2_2 = new WxMenuButton();
//            button2_2.setType("click"); //点击事件按钮
//            button2_2.setName("子菜单二");
//            button2_2.setKey("key3"); //根据标志获取点击菜单
//
//
//            WxMenuButton button3 = new WxMenuButton();
//            button3.setName("url菜单");
//            button3.setType("view");
//            button3.setUrl("http://www.baidu.com");  //必须添加http
//
//
//            List<WxMenuButton> subButtons = new ArrayList<WxMenuButton>();
//            subButtons.add(button2_1);
//            subButtons.add(button2_2);
//            button2.setSubButtons(subButtons);
//
//            List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();
//            buttons.add(button1);
//            buttons.add(button2);
//            buttons.add(button3);
//
//            WxMenu menu = new WxMenu();
//            menu.setButtons(buttons);
//
//            try {
//                wxMpService.getMenuService().menuCreate(menu);
//            } catch (WxErrorException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }

    }

}
