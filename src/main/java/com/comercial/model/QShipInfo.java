package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShipInfo is a Querydsl query type for ShipInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShipInfo extends EntityPathBase<ShipInfo> {

    private static final long serialVersionUID = -2132853269L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShipInfo shipInfo = new QShipInfo("shipInfo");

    public final StringPath address = createString("address");

    public final StringPath city = createString("city");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<Integer> idCountry = createNumber("idCountry", Integer.class);

    public final QDistrict idDistrict;

    public final NumberPath<Integer> idShipInfo = createNumber("idShipInfo", Integer.class);

    public final NumberPath<Integer> idUser = createNumber("idUser", Integer.class);

    public final StringPath postalCode = createString("postalCode");

    public final CollectionPath<Purchase, QPurchase> purchaseCollection = this.<Purchase, QPurchase>createCollection("purchaseCollection", Purchase.class, QPurchase.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QShipInfo(String variable) {
        this(ShipInfo.class, forVariable(variable), INITS);
    }

    public QShipInfo(Path<? extends ShipInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShipInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShipInfo(PathMetadata metadata, PathInits inits) {
        this(ShipInfo.class, metadata, inits);
    }

    public QShipInfo(Class<? extends ShipInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idDistrict = inits.isInitialized("idDistrict") ? new QDistrict(forProperty("idDistrict")) : null;
    }

}

