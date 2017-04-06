package com.comercial.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRoles is a Querydsl query type for UserRoles
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRoles extends EntityPathBase<UserRoles> {

    private static final long serialVersionUID = 1787718897L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserRoles userRoles = new QUserRoles("userRoles");

    public final StringPath role = createString("role");

    public final QUsers userId;

    public final NumberPath<Integer> userRoleId = createNumber("userRoleId", Integer.class);

    public QUserRoles(String variable) {
        this(UserRoles.class, forVariable(variable), INITS);
    }

    public QUserRoles(Path<? extends UserRoles> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserRoles(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserRoles(PathMetadata metadata, PathInits inits) {
        this(UserRoles.class, metadata, inits);
    }

    public QUserRoles(Class<? extends UserRoles> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new QUsers(forProperty("userId")) : null;
    }

}

