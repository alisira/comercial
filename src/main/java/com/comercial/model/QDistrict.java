package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDistrict is a Querydsl query type for District
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDistrict extends EntityPathBase<District> {

    private static final long serialVersionUID = -1326498705L;

    public static final QDistrict district = new QDistrict("district");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath denomination = createString("denomination");

    public final NumberPath<Integer> idDistrict = createNumber("idDistrict", Integer.class);

    public final CollectionPath<ShipInfo, QShipInfo> shipInfoCollection = this.<ShipInfo, QShipInfo>createCollection("shipInfoCollection", ShipInfo.class, QShipInfo.class, PathInits.DIRECT2);

    public final CollectionPath<Store, QStore> storeCollection = this.<Store, QStore>createCollection("storeCollection", Store.class, QStore.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QDistrict(String variable) {
        super(District.class, forVariable(variable));
    }

    public QDistrict(Path<? extends District> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDistrict(PathMetadata metadata) {
        super(District.class, metadata);
    }

}

