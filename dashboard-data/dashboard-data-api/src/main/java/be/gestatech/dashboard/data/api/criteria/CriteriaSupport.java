package be.gestatech.dashboard.data.api.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.SingularAttribute;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by amuri on 4/30/2017.
 */
public interface CriteriaSupport<E> {

    Criteria<E, E> criteria();

    <T> Criteria<T, T> where(Class<T> clazz);

    <T> Criteria<T, T> where(Class<T> clazz, JoinType joinType);

    <X> QuerySelection<E, X> attribute(SingularAttribute<? super E, X> attribute);

    <N extends Number> QuerySelection<E, N> abs(SingularAttribute<? super E, N> attribute);

    <N extends Number> QuerySelection<E, N> avg(SingularAttribute<? super E, N> attribute);

    QuerySelection<E, Long> count(SingularAttribute<? super E, ?> attribute);

    QuerySelection<E, Long> countDistinct(SingularAttribute<? super E, ?> attribute);

    <N extends Number> QuerySelection<E, N> max(SingularAttribute<? super E, N> attribute);

    <N extends Number> QuerySelection<E, N> min(SingularAttribute<? super E, N> attribute);

    <N extends Number> QuerySelection<E, N> neg(SingularAttribute<? super E, N> attribute);

    <N extends Number> QuerySelection<E, N> sum(SingularAttribute<? super E, N> attribute);

    QuerySelection<E, Integer> modulo(SingularAttribute<? super E, Integer> attribute, Integer modulo);

    QuerySelection<E, String> upper(SingularAttribute<? super E, String> attribute);

    QuerySelection<E, String> lower(SingularAttribute<? super E, String> attribute);

    QuerySelection<E, String> substring(SingularAttribute<? super E, String> attribute, int from);

    QuerySelection<E, String> substring(SingularAttribute<? super E, String> attribute, int from, int length);

    QuerySelection<E, String> trim(SingularAttribute<? super E, String> attribute);

    QuerySelection<E, String> trim(CriteriaBuilder.Trimspec trimspec, SingularAttribute<? super E, String> attribute);

    QuerySelection<E, Date> currDate();

    QuerySelection<E, Time> currTime();

    QuerySelection<E, Timestamp> currTStamp();
}
