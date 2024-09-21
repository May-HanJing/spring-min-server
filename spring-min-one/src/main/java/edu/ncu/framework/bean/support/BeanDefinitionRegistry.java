package edu.ncu.framework.bean.support;

import edu.ncu.framework.bean.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
