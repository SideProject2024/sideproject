package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserReview is a Querydsl query type for UserReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserReview extends EntityPathBase<UserReview> {

    private static final long serialVersionUID = 293201491L;

    public static final QUserReview userReview = new QUserReview("userReview");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Member, QMember> members = this.<Member, QMember>createList("members", Member.class, QMember.class, PathInits.DIRECT2);

    public final StringPath usercode = createString("usercode");

    public final ListPath<UserReReview, QUserReReview> userReReviews = this.<UserReReview, QUserReReview>createList("userReReviews", UserReReview.class, QUserReReview.class, PathInits.DIRECT2);

    public QUserReview(String variable) {
        super(UserReview.class, forVariable(variable));
    }

    public QUserReview(Path<? extends UserReview> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserReview(PathMetadata metadata) {
        super(UserReview.class, metadata);
    }

}

