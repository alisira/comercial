package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOffer is a Querydsl query type for ProductOffer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductOffer extends EntityPathBase<ProductOffer> {

    private static final long serialVersionUID = -1922708722L;

    public static final QProductOffer productOffer = new QProductOffer("productOffer");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> idOffer = createNumber("idOffer", Long.class);

    public final NumberPath<Integer> idProduct = createNumber("idProduct", Integer.class);

    public final NumberPath<Integer> idProductOffer = createNumber("idProductOffer", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QProductOffer(String variable) {
        super(ProductOffer.class, forVariable(variable));
    }

    public QProductOffer(Path<? extends ProductOffer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOffer(PathMetadata metadata) {
        super(ProductOffer.class, metadata);
    }

}

