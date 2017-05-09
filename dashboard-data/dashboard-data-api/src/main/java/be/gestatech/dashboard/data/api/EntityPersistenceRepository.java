package be.gestatech.dashboard.data.api;

import be.gestatech.dashboard.data.spi.activation.Deactivatable;

import java.io.Serializable;

/**
 * Created by amuri on 5/1/2017.
 */
public interface EntityPersistenceRepository<E, PK extends Serializable> extends Deactivatable {

    E save(E entity);

    E saveAndFlush(E entity);

    E saveAndFlushAndRefresh(E entity);

    void remove(E entity);

    void removeAndFlush(E entity);

    void attachAndRemove(E entity);

    void refresh(E entity);

    void flush();

    PK getPrimaryKey(E example);
}
