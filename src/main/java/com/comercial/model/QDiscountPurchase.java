package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscountPurchase is a Querydsl query type for DiscountPurchase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiscountPurchase extends EntityPathBase<DiscountPurchase> {

    private static final long serialVersionUID = -1652906685L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiscountPurchase discountPurchase = new QDiscountPurchase("discountPurchase");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> discount = createNumber("discount", java.math.BigInteger.class);

    public final QDiscount idDiscount;

    public final NumberPath<Integer> idDiscountPurchase = createNumber("idDiscountPurchase", Integer.class);

    public final QPurchase idPurchase;

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QDiscountPurchase(String variable) {
        this(DiscountPurchase.class, forVariable(variable), INITS);
    }

    public QDiscountPurchase(Path<? extends DiscountPurchase> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiscountPurchase(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiscountPurchase(PathMetadata metadata, PathInits inits) {
        this(DiscountPurchase.class, metadata, inits);
    }

    public QDiscountPurchase(Class<? extends DiscountPurchase> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idDiscount = inits.isInitialized("idDiscount") ? new QDiscount(forProperty("idDiscount")) : null;
        this.idPurchase = inits.isInitialized("idPurchase") ? new QPurchase(forProperty("idPurchase"), inits.get("idPurchase")) : null;
    }

}

