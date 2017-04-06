package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRelationatedProduct is a Querydsl query type for RelationatedProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelationatedProduct extends EntityPathBase<RelationatedProduct> {

    private static final long serialVersionUID = 442971520L;

    public static final QRelationatedProduct relationatedProduct = new QRelationatedProduct("relationatedProduct");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Integer> idProduct = createNumber("idProduct", Integer.class);

    public final NumberPath<Integer> idProductRelation = createNumber("idProductRelation", Integer.class);

    public final NumberPath<Integer> idRelationatedProduct = createNumber("idRelationatedProduct", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QRelationatedProduct(String variable) {
        super(RelationatedProduct.class, forVariable(variable));
    }

    public QRelationatedProduct(Path<? extends RelationatedProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelationatedProduct(PathMetadata metadata) {
        super(RelationatedProduct.class, metadata);
    }

}

