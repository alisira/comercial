package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscountUser is a Querydsl query type for DiscountUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiscountUser extends EntityPathBase<DiscountUser> {

    private static final long serialVersionUID = 1922497805L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiscountUser discountUser = new QDiscountUser("discountUser");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final QDiscount idDiscount;

    public final NumberPath<Integer> idDiscountUser = createNumber("idDiscountUser", Integer.class);

    public final NumberPath<Long> idUser = createNumber("idUser", Long.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QDiscountUser(String variable) {
        this(DiscountUser.class, forVariable(variable), INITS);
    }

    public QDiscountUser(Path<? extends DiscountUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiscountUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiscountUser(PathMetadata metadata, PathInits inits) {
        this(DiscountUser.class, metadata, inits);
    }

    public QDiscountUser(Class<? extends DiscountUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idDiscount = inits.isInitialized("idDiscount") ? new QDiscount(forProperty("idDiscount")) : null;
    }

}

