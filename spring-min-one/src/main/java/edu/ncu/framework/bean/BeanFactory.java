package edu.ncu.framework.bean;

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);
}
