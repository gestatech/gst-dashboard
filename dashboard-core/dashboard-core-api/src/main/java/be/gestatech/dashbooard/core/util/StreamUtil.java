package be.gestatech.dashbooard.core.util;

import javax.enterprise.inject.Typed;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by amuri on 4/30/2017.
 */
@Typed()
public abstract class StreamUtil {
    private static boolean streamSupported = true;
    private static Class<?> streamClass;
    private static Method streamMethod;

    static {
        try {
            streamClass = Class.forName("java.util.stream.Stream");
            streamMethod = Collection.class.getMethod("stream");
        } catch (Exception e) {
            streamSupported = false;
            streamClass = null;
            streamMethod = null;
        }
    }

    public static boolean isStreamSupported() {
        return streamSupported;
    }

    public static boolean isStreamReturned(Method method) {
        return isStreamSupported() && streamClass.isAssignableFrom(method.getReturnType());
    }

    public static Object wrap(Object input) {
        Object wrappedObject = null;
        if (!isStreamSupported() || Objects.isNull(input)) {
            wrappedObject = input;
        } else {
            try {
                wrappedObject = streamMethod.invoke(input);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        return wrappedObject;
    }
}
