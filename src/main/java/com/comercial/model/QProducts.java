package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProducts is a Querydsl query type for Products
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProducts extends EntityPathBase<Products> {

    private static final long serialVersionUID = 1675745861L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProducts products = new QProducts("products");

    public final StringPath code = createString("code");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath finish = createString("finish");

    public final QCategory idCategory;

    public final QColor idColor;

    public final QEnviroment idEnviroment;

    public final QImage idImage;

    public final NumberPath<Long> idProduct = createNumber("idProduct", Long.class);

    public final QPurpose idPurpose;

    public final NumberPath<Integer> itemBox = createNumber("itemBox", Integer.class);

    public final NumberPath<Double> kgMeter = createNumber("kgMeter", Double.class);

    public final StringPath material = createString("material");

    public final NumberPath<Double> measure = createNumber("measure", Double.class);

    public final StringPath name = createString("name");

    public final CollectionPath<OrderDetail, QOrderDetail> orderDetailCollection = this.<OrderDetail, QOrderDetail>createCollection("orderDetailCollection", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final StringPath palette = createString("palette");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final NumberPath<Double> priceSample = createNumber("priceSample", Double.class);

    public final StringPath rank = createString("rank");

    public final StringPath size = createString("size");

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final NumberPath<Double> stock = createNumber("stock", Double.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QProducts(String variable) {
        this(Products.class, forVariable(variable), INITS);
    }

    public QProducts(Path<? extends Products> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProducts(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProducts(PathMetadata metadata, PathInits inits) {
        this(Products.class, metadata, inits);
    }

    public QProducts(Class<? extends Products> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idCategory = inits.isInitialized("idCategory") ? new QCategory(forProperty("idCategory")) : null;
        this.idColor = inits.isInitialized("idColor") ? new QColor(forProperty("idColor")) : null;
        this.idEnviroment = inits.isInitialized("idEnviroment") ? new QEnviroment(forProperty("idEnviroment")) : null;
        this.idImage = inits.isInitialized("idImage") ? new QImage(forProperty("idImage")) : null;
        this.idPurpose = inits.isInitialized("idPurpose") ? new QPurpose(forProperty("idPurpose")) : null;
    }

}

