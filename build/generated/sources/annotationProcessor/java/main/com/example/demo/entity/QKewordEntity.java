package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKewordEntity is a Querydsl query type for KewordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKewordEntity extends EntityPathBase<KewordEntity> {

    private static final long serialVersionUID = -390803720L;

    public static final QKewordEntity kewordEntity = new QKewordEntity("kewordEntity");

    public final StringPath memberid = createString("memberid");

    public final StringPath movieid = createString("movieid");

    public final NumberPath<Integer> pkid = createNumber("pkid", Integer.class);

    public final StringPath word = createString("word");

    public QKewordEntity(String variable) {
        super(KewordEntity.class, forVariable(variable));
    }

    public QKewordEntity(Path<? extends KewordEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKewordEntity(PathMetadata metadata) {
        super(KewordEntity.class, metadata);
    }

}

