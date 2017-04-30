package be.gestatech.dashboard.data.api.mapping;

import be.gestatech.dashboard.data.spi.QueryInvocationContext;

import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by amuri on 4/30/2017.
 */
public abstract class SimpleQueryInOutMapperBase<Entity, Dto> implements QueryInOutMapper<Entity> {

    @Inject
    private QueryInvocationContext context;


    protected abstract Object getPrimaryKey(Dto dto);

    protected abstract Dto toDto(Entity entity);

    protected abstract Entity toEntity(Entity entity, Dto dto);

    @Override
    public Object mapResult(final Entity result) {
        Object mappedObject;
        if (Objects.isNull(result)) {
            mappedObject = null;
        } else {
            mappedObject = toDto(result);
        }
        return mappedObject;
    }

    @Override
    public Object mapResultList(final List<Entity> result) {
        Object mappedList = new ArrayList<>();
        if (Objects.nonNull(result)) {
            final List<Object> mapped = new ArrayList<>(result.size());
            for (final Entity a : result) {
                mapped.add(mapResult(a));
            }
            mappedList = mapped;
        }
        return mappedList;
    }

    @Override
    public boolean mapsParameter(final Object parameter) {
        boolean mappedParameter = false;
        if (Objects.nonNull(parameter)) {
            final String name = parameter.getClass().getName();
            mappedParameter =  Object.class.isInstance(parameter) && !(name.startsWith("java.") || name.startsWith("javax."));
        }
        return mappedParameter;
    }

    @Override
    public Object mapParameter(final Object parameter) {
        Dto dto = (Dto) parameter;
        Object primaryKey = getPrimaryKey(dto);
        if (Objects.nonNull(primaryKey)) {
            Entity entity = findEntity(primaryKey);
            return toEntity(entity, dto);
        }
        return toEntity(newEntity(), dto);
    }

    @SuppressWarnings("unchecked")
    protected Entity newEntity() {
        try {
            Class<?> entityClass = context.getEntityClass();
            Constructor<?> constructor = entityClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            return (Entity) constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed instantiating new Entity", e);
        }
    }

    @SuppressWarnings("unchecked")
    protected Entity findEntity(Object primaryKey) {
        return (Entity) context.getEntityManager().find(context.getEntityClass(), primaryKey);
    }
}
