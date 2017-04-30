package be.gestatech.dashboard.data.api.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Selection;

/**
 * Created by amuri on 4/30/2017.
 */
public interface QuerySelection<P, X> {

    /**
     * Convert the instance to a criteria selection.
     *
     * @param query   The current criteria query.
     * @param builder The query builder used to instantiate the selection.
     * @param path    Current path.
     * @return Criteria API selection instance corresponding to the
     * QuerySelection implementation.
     */
    <R> Selection<X> toSelection(CriteriaQuery<R> query, CriteriaBuilder builder, Path<? extends P> path);
}
