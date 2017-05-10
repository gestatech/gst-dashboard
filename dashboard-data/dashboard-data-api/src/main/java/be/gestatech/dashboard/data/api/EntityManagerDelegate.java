package be.gestatech.dashboard.data.api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
 * Created by amurifa on 10/05/2017.
 */
public interface EntityManagerDelegate<E> {

    void persist(E entity);

    E merge(E entity);

    E find(Object primaryKey, Map<String, Object> properties);

    E find(Object primaryKey, LockModeType lockMode);

    E find(Object primaryKey, LockModeType lockMode, Map<String, Object> properties);

    E getReference(Object primaryKey);

    void setFlushMode(FlushModeType flushMode);

    FlushModeType getFlushMode();

    void lock(Object entity, LockModeType lockMode);

    void lock(Object entity, LockModeType lockMode, Map<String, Object> properties);

    void refresh(E entity, Map<String, Object> properties);

    void refresh(E entity, LockModeType lockMode);

    void refresh(E entity, LockModeType lockMode, Map<String, Object> properties);

    void clear();

    void detach(E entity);

    boolean contains(E entity);

    LockModeType getLockMode(E entity);

    void setProperty(String propertyName, Object value);

    Map<String, Object> getProperties();

    void joinTransaction();


    <T> T unwrap(Class<T> cls);

    Object getDelegate();

    void close();

    boolean isOpen();

    EntityTransaction getTransaction();

    EntityManagerFactory getEntityManagerFactory();

    CriteriaBuilder getCriteriaBuilder();

    Metamodel getMetamodel();
}
