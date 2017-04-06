package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIpn is a Querydsl query type for Ipn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIpn extends EntityPathBase<Ipn> {

    private static final long serialVersionUID = 1957676710L;

    public static final QIpn ipn = new QIpn("ipn");

    public final DateTimePath<java.util.Date> fecha = createDateTime("fecha", java.util.Date.class);

    public final NumberPath<Integer> idIpn = createNumber("idIpn", Integer.class);

    public final StringPath valor = createString("valor");

    public QIpn(String variable) {
        super(Ipn.class, forVariable(variable));
    }

    public QIpn(Path<? extends Ipn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIpn(PathMetadata metadata) {
        super(Ipn.class, metadata);
    }

}

