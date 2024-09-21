package edu.ncu.framework.bean.support;

import edu.ncu.framework.bean.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author HanJing
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args);
}
