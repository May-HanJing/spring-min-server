package edu.ncu.framework.bean.support;

import edu.ncu.framework.bean.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author HanJing
 */
public class CglibInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
             return    super.hashCode();
            }
        });
        if(constructor==null){
            return enhancer.create();
        }

        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
