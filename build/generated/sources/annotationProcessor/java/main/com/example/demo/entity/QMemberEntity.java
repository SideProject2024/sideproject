package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -2081947218L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath Email = createString("Email");

    public final NumberPath<Long> memberID = createNumber("memberID", Long.class);

    public final StringPath Name = createString("Name");

    public final StringPath Password = createString("Password");

    public final StringPath Profile = createString("Profile");

    public final StringPath Role = createString("Role");

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

