package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEnviroment is a Querydsl query type for Enviroment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnviroment extends EntityPathBase<Enviroment> {

    private static final long serialVersionUID = -37133864L;

    public static final QEnviroment enviroment = new QEnviroment("enviroment");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath denomination = createString("denomination");

    public final NumberPath<Integer> idEnviroment = createNumber("idEnviroment", Integer.class);

    public final NumberPath<Integer> idImage = createNumber("idImage", Integer.class);

    public final CollectionPath<Products, QProducts> productsCollection = this.<Products, QProducts>createCollection("productsCollection", Products.class, QProducts.class, PathInits.DIRECT2);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QEnviroment(String variable) {
        super(Enviroment.class, forVariable(variable));
    }

    public QEnviroment(Path<? extends Enviroment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnviroment(PathMetadata metadata) {
        super(Enviroment.class, metadata);
    }

}

