package edu.ncu.framework.bean.config;

/**
 * @author HanJing
 */
public interface SingletonBeanRegistry {

   Object getSingleton(String beanName);
}
