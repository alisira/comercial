package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 137237005L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> discount = createNumber("discount", java.math.BigInteger.class);

    public final NumberPath<Integer> idOrder = createNumber("idOrder", Integer.class);

    public final NumberPath<Integer> idShipInfo = createNumber("idShipInfo", Integer.class);

    public final NumberPath<Integer> idUser = createNumber("idUser", Integer.class);

    public final CollectionPath<OrderDetail, QOrderDetail> orderDetailCollection = this.<OrderDetail, QOrderDetail>createCollection("orderDetailCollection", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final CollectionPath<Payment, QPayment> paymentCollection = this.<Payment, QPayment>createCollection("paymentCollection", Payment.class, QPayment.class, PathInits.DIRECT2);

    public final CollectionPath<Purchase, QPurchase> purchaseCollection = this.<Purchase, QPurchase>createCollection("purchaseCollection", Purchase.class, QPurchase.class, PathInits.DIRECT2);

    public final QStatus status;

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.status = inits.isInitialized("status") ? new QStatus(forProperty("status")) : null;
    }

}

