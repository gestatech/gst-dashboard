package be.gestatech.dashboard.data.api;

import be.gestatech.dashboard.data.api.partialbean.PartialBeanBinding;

import javax.enterprise.inject.Stereotype;
import java.lang.annotation.*;

/**
 * Created by amuri on 4/30/2017.
 */
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@PartialBeanBinding
public @interface Repository {

    Class<?> forEntity() default Object.class;

    String methodPrefix() default "";
}