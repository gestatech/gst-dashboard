package be.gestatech.dashbooard.core.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created by amuri on 4/30/2017.
 */
public class LoggerProducer {
    @Produces
    public Logger produce(InjectionPoint ip) {
        String clazz = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(clazz);
    }
}
