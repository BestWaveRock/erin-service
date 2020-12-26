package com.erin.base.core;

import com.erin.base.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Sunlight
 * @date 2018/7/21
 */
@Component
public class BaseServiceServerListener implements ApplicationListener {
    private static Logger log = LoggerFactory.getLogger(BaseServiceServerListener.class);

    @Value("${spring.profiles.active}")
    private static String profilesActive;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) { // 初始化环境变量
            log.info("==========初始化环境变量==============");
        } else if (event instanceof ApplicationPreparedEvent) { // 初始化完成
            log.info("==========初始化完成==============");
        } else if (event instanceof ContextRefreshedEvent) { // 应用刷新
            log.info("==========应用刷新==============");
        } else if (event instanceof ApplicationReadyEvent) {// 应用已启动完成
            log.info("=================================");
            log.info("系统[{}]启动完成!!!", "baseService");
            log.info("启动环境：{}", profilesActive);
            log.info("=================================");

        } else if (event instanceof ContextStartedEvent) { // 应用启动，需要在代码动态添加监听器才可捕获
            log.info("==========应用启动==============");
        } else if (event instanceof ContextStoppedEvent) { // 应用停止
            log.info("==========应用停止==============");
        } else if (event instanceof ContextClosedEvent) { // 应用关闭
            log.info("==========应用关闭==============");
        } else {
        }
    }
}
