package be.gestatech.dashboard.data.api.mapping;

import java.lang.annotation.*;

/**
 * Created by amuri on 4/30/2017.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MappingConfiguration {

    Class<? extends QueryInOutMapper<?>> value();
}
