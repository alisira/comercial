package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscount is a Querydsl query type for Discount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiscount extends EntityPathBase<Discount> {

    private static final long serialVersionUID = -1342276062L;

    public static final QDiscount discount = new QDiscount("discount");

    public final NumberPath<Double> aliquot = createNumber("aliquot", Double.class);

    public final StringPath code = createString("code");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateEnd = createDateTime("dateEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateInit = createDateTime("dateInit", java.util.Date.class);

    public final StringPath description = createString("description");

    public final CollectionPath<DiscountPurchase, QDiscountPurchase> discountPurchaseCollection = this.<DiscountPurchase, QDiscountPurchase>createCollection("discountPurchaseCollection", DiscountPurchase.class, QDiscountPurchase.class, PathInits.DIRECT2);

    public final CollectionPath<DiscountUser, QDiscountUser> discountUserCollection = this.<DiscountUser, QDiscountUser>createCollection("discountUserCollection", DiscountUser.class, QDiscountUser.class, PathInits.DIRECT2);

    public final NumberPath<Short> idCalcuBase = createNumber("idCalcuBase", Short.class);

    public final NumberPath<Integer> idDiscount = createNumber("idDiscount", Integer.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final NumberPath<Short> typeUser = createNumber("typeUser", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final NumberPath<Short> useLimit = createNumber("useLimit", Short.class);

    public QDiscount(String variable) {
        super(Discount.class, forVariable(variable));
    }

    public QDiscount(Path<? extends Discount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscount(PathMetadata metadata) {
        super(Discount.class, metadata);
    }

}

