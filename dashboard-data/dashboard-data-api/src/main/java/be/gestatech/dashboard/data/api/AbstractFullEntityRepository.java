package be.gestatech.dashboard.data.api;

import java.io.Serializable;

/**
 * Created by amurifa on 10/05/2017.
 */
public abstract class AbstractFullEntityRepository<E, PK extends Serializable> extends AbstractEntityRepository<E, PK> implements FullEntityRepository<E, PK> {
}
