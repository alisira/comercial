package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductDiscount is a Querydsl query type for ProductDiscount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductDiscount extends EntityPathBase<ProductDiscount> {

    private static final long serialVersionUID = -689852593L;

    public static final QProductDiscount productDiscount = new QProductDiscount("productDiscount");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> idDiscount = createNumber("idDiscount", Long.class);

    public final NumberPath<Long> idProduct = createNumber("idProduct", Long.class);

    public final NumberPath<Integer> idProductDiscount = createNumber("idProductDiscount", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QProductDiscount(String variable) {
        super(ProductDiscount.class, forVariable(variable));
    }

    public QProductDiscount(Path<? extends ProductDiscount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductDiscount(PathMetadata metadata) {
        super(ProductDiscount.class, metadata);
    }

}

