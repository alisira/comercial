package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurchase is a Querydsl query type for Purchase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchase extends EntityPathBase<Purchase> {

    private static final long serialVersionUID = 127864290L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPurchase purchase = new QPurchase("purchase");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final CollectionPath<DiscountPurchase, QDiscountPurchase> discountPurchaseCollection = this.<DiscountPurchase, QDiscountPurchase>createCollection("discountPurchaseCollection", DiscountPurchase.class, QDiscountPurchase.class, PathInits.DIRECT2);

    public final QOrder idOrder;

    public final NumberPath<Integer> idPayment = createNumber("idPayment", Integer.class);

    public final NumberPath<Integer> idPurchase = createNumber("idPurchase", Integer.class);

    public final QShipInfo idShipInfo;

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QPurchase(String variable) {
        this(Purchase.class, forVariable(variable), INITS);
    }

    public QPurchase(Path<? extends Purchase> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPurchase(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPurchase(PathMetadata metadata, PathInits inits) {
        this(Purchase.class, metadata, inits);
    }

    public QPurchase(Class<? extends Purchase> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idOrder = inits.isInitialized("idOrder") ? new QOrder(forProperty("idOrder"), inits.get("idOrder")) : null;
        this.idShipInfo = inits.isInitialized("idShipInfo") ? new QShipInfo(forProperty("idShipInfo"), inits.get("idShipInfo")) : null;
    }

}

