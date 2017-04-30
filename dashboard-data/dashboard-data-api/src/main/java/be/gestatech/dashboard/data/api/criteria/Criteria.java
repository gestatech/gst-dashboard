package be.gestatech.dashboard.data.api.criteria;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by amuri on 4/30/2017.
 */
public interface Criteria<C, R> {
    
    List<R> getResultList();

    R getSingleResult();
    R getOptionalResult();
    R getAnyResult();

    TypedQuery<R> createQuery();

    Criteria<C, R> or(Criteria<C, R>... criteria);
    Criteria<C, R> or(Collection<Criteria<C, R>> criteria);

    <P, E> Criteria<C, R> join(SingularAttribute<? super C, P> attribute, Criteria<P, P> criteria);
    <P, E> Criteria<C, R> join(ListAttribute<? super C, P> attribute, Criteria<P, P> criteria);
    <P, E> Criteria<C, R> join(CollectionAttribute<? super C, P> attribute, Criteria<P, P> criteria);
    <P, E> Criteria<C, R> join(SetAttribute<? super C, P> attribute, Criteria<P, P> criteria);
    <P, E> Criteria<C, R> join(MapAttribute<? super C, E, P> attribute, Criteria<P, P> criteria);
    <P, E> Criteria<C, R> fetch(SingularAttribute<? super C, P> attribute);
    <P, E> Criteria<C, R> fetch(SingularAttribute<? super C, P> attribute, JoinType joinType);
    <P, E> Criteria<C, R> fetch(PluralAttribute<? super C, P, E> attribute);
    <P, E> Criteria<C, R> fetch(PluralAttribute<? super C, P, E> attribute, JoinType joinType);

    <P> Criteria<C, R> orderAsc(SingularAttribute<? super C, P> attribute);
    <P> Criteria<C, R> orderDesc(SingularAttribute<? super C, P> attribute);

    <N> Criteria<C, N> select(Class<N> resultClass, QuerySelection<? super C, ?>... selection);

    Criteria<C, Object[]> select(QuerySelection<? super C, ?>... selection);
    Criteria<C, R> distinct();

    <P> Criteria<C, R> eq(SingularAttribute<? super C, P> attribute, P value);
    <P> Criteria<C, R> eqIgnoreCase(SingularAttribute<? super C, String> attribute, String value);
    <P> Criteria<C, R> notEq(SingularAttribute<? super C, P> attribute, P value);
    <P> Criteria<C, R> notEqIgnoreCase(SingularAttribute<? super C, String> attribute, String value);
    <P> Criteria<C, R> like(SingularAttribute<? super C, String> attribute, String value);
    <P> Criteria<C, R> likeIgnoreCase(SingularAttribute<? super C, String> attribute, String value);
    <P> Criteria<C, R> notLike(SingularAttribute<? super C, String> attribute, String value);
    <P> Criteria<C, R> notLikeIgnoreCase(SingularAttribute<? super C, String> attribute, String value);

    <P extends Comparable<? super P>> Criteria<C, R> lt(SingularAttribute<? super C, P> attribute, P value);
    <P extends Comparable<? super P>> Criteria<C, R> ltOrEq(SingularAttribute<? super C, P> attribute, P value);
    <P extends Comparable<? super P>> Criteria<C, R> gt(SingularAttribute<? super C, P> attribute, P value);
    <P extends Comparable<? super P>> Criteria<C, R> gtOrEq(SingularAttribute<? super C, P> attribute, P value);
    <P extends Comparable<? super P>> Criteria<C, R> between(SingularAttribute<? super C, P> attribute, P lower, P upper);

    <P> Criteria<C, R> isNull(SingularAttribute<? super C, P> attribute);
    <P> Criteria<C, R> notNull(SingularAttribute<? super C, P> attribute);

    <P extends Collection<?>> Criteria<C, R> empty(SingularAttribute<? super C, P> attribute);
    <P extends Collection<?>> Criteria<C, R> notEmpty(SingularAttribute<? super C, P> attribute);

    <P> Criteria<C, R> in(SingularAttribute<? super C, P> attribute, P... values);

    List<Predicate> predicates(CriteriaBuilder builder, Path<C> path);
}
