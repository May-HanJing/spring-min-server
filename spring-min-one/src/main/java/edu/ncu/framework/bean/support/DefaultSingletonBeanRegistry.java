package edu.ncu.framework.bean.support;

import edu.ncu.framework.bean.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HanJing
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

   Map<String,Object> beanMap = new ConcurrentHashMap<>();
    @Override
    public Object getSingleton(String beanName) {
       return beanMap.get(beanName);
    }

    protected  void addSingleton(String beanName,Object bean){
        beanMap.put(beanName,bean);
    }
}
