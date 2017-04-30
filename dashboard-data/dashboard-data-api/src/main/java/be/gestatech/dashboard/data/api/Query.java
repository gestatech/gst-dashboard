package be.gestatech.dashboard.data.api;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.lang.annotation.*;

/**
 * Created by amuri on 4/30/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Query {

    String value() default "";

    String named() default "";

    boolean isNative() default false;

    int max() default 0;

    LockModeType lock() default LockModeType.NONE;

    QueryHint[] hints() default {};

    SingleResultType singleResult() default SingleResultType.JPA;
}
