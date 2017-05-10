package be.gestatech.dashboard.data.api;

import be.gestatech.dashboard.data.api.criteria.CriteriaSupport;

import java.io.Serializable;

/**
 * Created by amurifa on 10/05/2017.
 */
public interface FullEntityRepository <E, PK extends Serializable> extends EntityRepository<E, PK>, EntityManagerDelegate<E>, CriteriaSupport<E> {
}
