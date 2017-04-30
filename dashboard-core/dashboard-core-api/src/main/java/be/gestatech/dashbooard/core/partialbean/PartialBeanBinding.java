package be.gestatech.dashbooard.core.partialbean;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by amuri on 4/30/2017.
 */
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface PartialBeanBinding {
}
