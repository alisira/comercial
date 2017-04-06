package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -838792955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final NumberPath<Double> amountRefunded = createNumber("amountRefunded", Double.class);

    public final StringPath collectionId = createString("collectionId");

    public final StringPath currencyId = createString("currencyId");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateApproved = createDateTime("dateApproved", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateCreated = createDateTime("dateCreated", java.util.Date.class);

    public final StringPath externalReference = createString("externalReference");

    public final QOrder idOrder;

    public final NumberPath<Integer> idPayment = createNumber("idPayment", Integer.class);

    public final DateTimePath<java.util.Date> lastModified = createDateTime("lastModified", java.util.Date.class);

    public final StringPath merchantOrderId = createString("merchantOrderId");

    public final StringPath operationType = createString("operationType");

    public final StringPath paymentType = createString("paymentType");

    public final StringPath preferenceId = createString("preferenceId");

    public final NumberPath<Double> shippingCost = createNumber("shippingCost", Double.class);

    public final StringPath status = createString("status");

    public final StringPath statusDetail = createString("statusDetail");

    public final NumberPath<Double> totalPaidAmount = createNumber("totalPaidAmount", Double.class);

    public final NumberPath<Double> transactionAmount = createNumber("transactionAmount", Double.class);

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idOrder = inits.isInitialized("idOrder") ? new QOrder(forProperty("idOrder"), inits.get("idOrder")) : null;
    }

}

