package be.gestatech.dashboard.data.spi;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;

/**
 * Created by amuri on 4/30/2017.
 */
public interface QueryInvocationContext {

    EntityManager getEntityManager();

    Class<?> getEntityClass();

    boolean isNew(Object entity);

    Class<?> getRepositoryClass();

    Method getMethod();
}
