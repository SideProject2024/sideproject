package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMainContents is a Querydsl query type for MainContents
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMainContents extends EntityPathBase<MainContents> {

    private static final long serialVersionUID = 1389151043L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMainContents mainContents = new QMainContents("mainContents");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QMainContents(String variable) {
        this(MainContents.class, forVariable(variable), INITS);
    }

    public QMainContents(Path<? extends MainContents> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMainContents(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMainContents(PathMetadata metadata, PathInits inits) {
        this(MainContents.class, metadata, inits);
    }

    public QMainContents(Class<? extends MainContents> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

