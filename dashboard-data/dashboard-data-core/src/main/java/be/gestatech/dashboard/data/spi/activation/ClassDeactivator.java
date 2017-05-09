package be.gestatech.dashboard.data.spi.activation;

import java.io.Serializable;

/**
 * Created by amuri on 5/9/2017.
 */
public interface ClassDeactivator extends Serializable {
    Boolean isActivated(Class<? extends Deactivatable> targetClass);
}
