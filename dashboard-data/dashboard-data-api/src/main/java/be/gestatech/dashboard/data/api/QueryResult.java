package be.gestatech.dashboard.data.api;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

/**
 * Created by amuri on 4/30/2017.
 */
public interface QueryResult<E> {

    <X> QueryResult<E> orderAsc(SingularAttribute<E, X> attribute);
    <X> QueryResult<E> orderAsc(SingularAttribute<E, X> attribute, boolean appendEntityName);

    QueryResult<E> orderAsc(String attribute);
    QueryResult<E> orderAsc(String attribute, boolean appendEntityName);

    <X> QueryResult<E> orderDesc(SingularAttribute<E, X> attribute);

    <X> QueryResult<E> orderDesc(SingularAttribute<E, X> attribute, boolean appendEntityName);

    QueryResult<E> orderDesc(String attribute);
    QueryResult<E> orderDesc(String attribute, boolean appendEntityName);

    <X> QueryResult<E> changeOrder(SingularAttribute<E, X> attribute);

    QueryResult<E> clearOrder();
    QueryResult<E> changeOrder(String attribute);
    QueryResult<E> maxResults(int max);
    QueryResult<E> firstResult(int first);
    QueryResult<E> lockMode(LockModeType lockMode);
    QueryResult<E> flushMode(FlushModeType flushMode);
    QueryResult<E> hint(String hint, Object value);

    List<E> getResultList();

    E getSingleResult();
    E getOptionalResult();
    E getAnyResult();

    long count();
    QueryResult<E> withPageSize(int pageSize);
    QueryResult<E> toPage(int page);
    QueryResult<E> nextPage();
    QueryResult<E> previousPage();

    int countPages();
    int currentPage();
    int pageSize();

}
