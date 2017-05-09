package be.gestatech.dashboard.data.api;

import javax.persistence.metamodel.SingularAttribute;

/**
 * Created by amuri on 5/1/2017.
 */
public interface EntityCountRepository<E> {

    Long count();

    Long count(E example, SingularAttribute<E, ?>... attributes);

    Long countLike(E example, SingularAttribute<E, ?>... attributes);
}
