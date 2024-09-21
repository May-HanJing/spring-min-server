package edu.ncu.framework.bean.support;

import cn.hutool.core.bean.BeanUtil;
import edu.ncu.framework.bean.PropertyValue;
import edu.ncu.framework.bean.PropertyValues;
import edu.ncu.framework.bean.config.BeanDefinition;
import edu.ncu.framework.bean.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author HanJing
 */
public abstract  class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();
/*
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object obj = null;
        try {
           Class<?> beanClass = beanDefinition.getBeanClass();
            obj = beanClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

       addSingleton(beanName,obj);
        return obj;
    }*/

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;

        bean = instantiateBean(beanName,beanDefinition,args);
        applyPropertyValues(beanName,bean,beanDefinition);
        addSingleton(beanName,bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getBeanName());
            }
            BeanUtil.setFieldValue(bean,name,value);
        }
    }

    protected Object instantiateBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructor = beanClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructor) {
            if(args!=null && c.getParameterCount() == args.length){
                constructor = c;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }

    private InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
