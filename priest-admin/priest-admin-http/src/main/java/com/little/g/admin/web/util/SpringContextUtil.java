package com.little.g.admin.web.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringContextUtil implements ApplicationContextAware {

    /**
     * 以静态变量保存ApplicationContext,可在任意代码中取出ApplicaitonContext.
     */
    private static ApplicationContext context;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    public void setApplicationContext(ApplicationContext context) {
        if (SpringContextUtil.context == null)
        {
            SpringContextUtil.context = context;
        }
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        return context.getBean(name, requiredType);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
