package edu.ncu.framework.bean.support;

import cn.hutool.core.util.ObjectUtil;
import edu.ncu.framework.bean.BeanFactory;
import edu.ncu.framework.bean.config.BeanDefinition;

/**
 * @author HanJing
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry  implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
       return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName,args);
    }

    protected  <T> T doGetBean(String beanName, final Object[] args) {
        Object singleton = getSingleton(beanName);
        if (ObjectUtil.isNotNull(singleton)) {
            return (T)singleton;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T)createBean(beanName,beanDefinition,args);
    }


   // protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args);
}
