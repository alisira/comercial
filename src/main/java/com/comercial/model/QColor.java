package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QColor is a Querydsl query type for Color
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QColor extends EntityPathBase<Color> {

    private static final long serialVersionUID = 126073378L;

    public static final QColor color = new QColor("color");

    public final StringPath class1 = createString("class1");

    public final StringPath classM = createString("classM");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath d = createString("d");

    public final StringPath denomination = createString("denomination");

    public final StringPath hex = createString("hex");

    public final NumberPath<Integer> idColor = createNumber("idColor", Integer.class);

    public final CollectionPath<Products, QProducts> productsCollection = this.<Products, QProducts>createCollection("productsCollection", Products.class, QProducts.class, PathInits.DIRECT2);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QColor(String variable) {
        super(Color.class, forVariable(variable));
    }

    public QColor(Path<? extends Color> path) {
        super(path.getType(), path.getMetadata());
    }

    public QColor(PathMetadata metadata) {
        super(Color.class, metadata);
    }

}

