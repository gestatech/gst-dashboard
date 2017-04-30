package be.gestatech.dashbooard.core.util;

import javax.enterprise.inject.Typed;
import java.util.Objects;

/**
 * Created by amuri on 4/30/2017.
 */
@Typed()
public abstract class StringUtils {
    /**
     * Constructor which prevents the instantiation of this class
     */
    private StringUtils() {
        throw new RuntimeException();
    }

    public static boolean isEmpty(String string) {
        return Objects.isNull(string) || string.trim().isEmpty();
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }
}
