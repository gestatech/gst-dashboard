package be.gestatech.dashboard.data.api;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by amurifa on 10/05/2017.
 */
@Repository
public abstract class AbstractEntityRepository<E, PK extends Serializable> implements EntityRepository<E, PK>, EntityPersistenceRepository<E, PK>, EntityCountRepository<E> {

    protected abstract EntityManager entityManager();

    protected abstract CriteriaQuery<E> criteriaQuery();

    protected abstract TypedQuery<E> typedQuery(String qlString);

    protected abstract Class<E> entityClass();

    protected abstract String tableName();

    protected abstract String entityName();

}
