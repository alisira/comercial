package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurpose is a Querydsl query type for Purpose
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurpose extends EntityPathBase<Purpose> {

    private static final long serialVersionUID = -272575459L;

    public static final QPurpose purpose = new QPurpose("purpose");

    public final StringPath denomination = createString("denomination");

    public final NumberPath<Integer> idPurpose = createNumber("idPurpose", Integer.class);

    public final CollectionPath<Products, QProducts> productsCollection = this.<Products, QProducts>createCollection("productsCollection", Products.class, QProducts.class, PathInits.DIRECT2);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public QPurpose(String variable) {
        super(Purpose.class, forVariable(variable));
    }

    public QPurpose(Path<? extends Purpose> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurpose(PathMetadata metadata) {
        super(Purpose.class, metadata);
    }

}

