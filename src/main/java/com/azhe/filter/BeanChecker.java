package com.azhe.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class BeanChecker {

//    @Autowired
    private ApplicationContext applicationContext;

//    @EventListener(ContextRefreshedEvent.class)
    public void checkBean() {
        boolean beanExists = applicationContext.containsBean("filterDemo");

        if (beanExists) {
            System.out.println("FilterDemo bean is registered in the application context.");
        } else {
            System.out.println("FilterDemo bean is NOT registered in the application context.");
        }

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // 掃描測試
            System.out.println(beanDefinitionName);
        }
    }
}

