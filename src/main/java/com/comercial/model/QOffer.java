package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOffer is a Querydsl query type for Offer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOffer extends EntityPathBase<Offer> {

    private static final long serialVersionUID = 136881435L;

    public static final QOffer offer = new QOffer("offer");

    public final NumberPath<Double> aliquot = createNumber("aliquot", Double.class);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateEnd = createDateTime("dateEnd", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateInit = createDateTime("dateInit", java.util.Date.class);

    public final StringPath denomination = createString("denomination");

    public final StringPath description = createString("description");

    public final NumberPath<Short> idCalcuBase = createNumber("idCalcuBase", Short.class);

    public final NumberPath<Integer> idOffer = createNumber("idOffer", Integer.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QOffer(String variable) {
        super(Offer.class, forVariable(variable));
    }

    public QOffer(Path<? extends Offer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOffer(PathMetadata metadata) {
        super(Offer.class, metadata);
    }

}

