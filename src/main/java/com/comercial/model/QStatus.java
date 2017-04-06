package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStatus is a Querydsl query type for Status
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatus extends EntityPathBase<Status> {

    private static final long serialVersionUID = 75668755L;

    public static final QStatus status = new QStatus("status");

    public final StringPath denomination = createString("denomination");

    public final NumberPath<Integer> idStatus = createNumber("idStatus", Integer.class);

    public final CollectionPath<Order, QOrder> orderCollection = this.<Order, QOrder>createCollection("orderCollection", Order.class, QOrder.class, PathInits.DIRECT2);

    public final StringPath shortcut = createString("shortcut");

    public final StringPath table = createString("table");

    public QStatus(String variable) {
        super(Status.class, forVariable(variable));
    }

    public QStatus(Path<? extends Status> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatus(PathMetadata metadata) {
        super(Status.class, metadata);
    }

}

