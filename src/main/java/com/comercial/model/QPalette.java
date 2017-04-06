package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPalette is a Querydsl query type for Palette
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPalette extends EntityPathBase<Palette> {

    private static final long serialVersionUID = -851022470L;

    public static final QPalette palette = new QPalette("palette");

    public final StringPath denomination = createString("denomination");

    public final NumberPath<Integer> idPalette = createNumber("idPalette", Integer.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public QPalette(String variable) {
        super(Palette.class, forVariable(variable));
    }

    public QPalette(Path<? extends Palette> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPalette(PathMetadata metadata) {
        super(Palette.class, metadata);
    }

}

