package be.gestatech.dashboard.data.api.mapping;

import java.util.List;

/**
 * Created by amuri on 4/30/2017.
 */
public interface QueryInOutMapper<E> {

    Object mapResult(E result);

    Object mapResultList(List<E> result);

    boolean mapsParameter(Object parameter);

    Object mapParameter(Object parameter);
}
