package edu.ncu.framework.bean.support;

import edu.ncu.framework.bean.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author HanJing
 */
public class JKDInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();

        try {
            if(constructor != null){
                if(constructor.getParameterCount() == args.length){
                    return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
                }
            }
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化bean失败");
        }

    }
}
