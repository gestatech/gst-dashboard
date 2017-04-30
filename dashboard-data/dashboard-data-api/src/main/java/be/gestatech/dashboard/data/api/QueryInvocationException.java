package be.gestatech.dashboard.data.api;

import be.gestatech.dashboard.data.spi.QueryInvocationContext;

import java.lang.reflect.Method;

/**
 * Created by amuri on 4/30/2017.
 */
public class QueryInvocationException extends RuntimeException {

    private static final long serialVersionUID = 6268683295398802010L;

    public QueryInvocationException(Throwable t, QueryInvocationContext context) {
        super(createMessage(context, t), t);
    }

    public QueryInvocationException(String message, QueryInvocationContext context) {
        super(createMessage(context));
    }

    public QueryInvocationException(Throwable t, Class<?> proxy, Method method) {
        super(createMessage(proxy, method, t), t);
    }

    private static String createMessage(QueryInvocationContext context) {
        StringBuilder builder = new StringBuilder();
        builder.append("Failed calling Repository: [");
        builder.append("Repository=").append(context.getRepositoryClass().getName()).append(",");
        builder.append("entity=").append(context.getEntityClass().getName()).append(",");
        builder.append("method=").append(context.getMethod().getName()).append(",");
        return builder.toString();
    }

    private static String createMessage(QueryInvocationContext context, Throwable t) {
        StringBuilder builder = new StringBuilder(createMessage(context));
        builder.append("exception=").append(t.getClass()).append(",message=").append(t.getMessage());
        return builder.toString();
    }

    private static String createMessage(Class<?> repoClass, Method method, Throwable t) {
        StringBuilder builder = new StringBuilder();
        builder.append("Exception calling Repository: [");
        builder.append("Repository=").append(repoClass).append(",");
        builder.append("method=").append(method.getName()).append("],");
        builder.append("exception=").append(t.getClass()).append(",message=").append(t.getMessage());
        return builder.toString();
    }
}
