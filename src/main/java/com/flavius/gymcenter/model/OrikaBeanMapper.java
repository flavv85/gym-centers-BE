package com.flavius.gymcenter.model;
//Orika is a bean to bean mapping framework that recursively copies data from one object to another.
//The general principle of work of the Orika is similar to Dozer. The main difference between the two is the fact that
// Orika uses bytecode generation. This allows for generating faster mappers with minimal overhead.
// Will convert entity => DTO / DTO => entity
//https://www.baeldung.com/java-performance-mapping-frameworks

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

public class OrikaBeanMapper extends ConfigurableMapper {
    private MapperFactory factory;

    public OrikaBeanMapper() {
        super(false);
        init();
    }

    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;
    }

    private void registerClassMap(Class a, Class b) {
        this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    //    Register class map with fields to exclude
    private void registerClassMap(Class a, Class b, String... excludeFields) {
        ClassMapBuilder builder = this.factory.classMap(a, b);
        for (String excludeField : excludeFields) {
            builder.exclude(excludeField);
        }
        builder.mapNulls(true).mapNullsInReverse(true).byDefault().register();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.compilerStrategy(new JavassistCompilerStrategy());
        factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
    }

    //    convert entity => DTO / DTO => entity
    public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) {
        if (from == null) {
            return null;
        }
        return mapAsList(from, toClass);
    }

    public <T, U> Page<T> convertPageDTO(Page<U> from, Class<T> toClass) {
        if (from == null) {
            return null;
        }
        return from.map(entity -> factory.getMapperFacade().map(entity, toClass));
    }
}
