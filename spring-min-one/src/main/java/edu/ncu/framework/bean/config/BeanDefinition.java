package edu.ncu.framework.bean.config;

import edu.ncu.framework.bean.PropertyValues;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HanJing
 */
@Data
@NoArgsConstructor
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
}
