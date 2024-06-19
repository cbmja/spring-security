package com.campusMatch.CM.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -442192559L;

    public static final QMember member = new QMember("member1");

    public final com.campusMatch.CM.util.QBase _super = new com.campusMatch.CM.util.QBase(this);

    public final NumberPath<Integer> applyCnt = createNumber("applyCnt", Integer.class);

    public final ListPath<Authorities, QAuthorities> authorities = this.<Authorities, QAuthorities>createList("authorities", Authorities.class, QAuthorities.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    public final StringPath campusCode = createString("campusCode");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final BooleanPath enable = createBoolean("enable");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final StringPath kakaoId = createString("kakaoId");

    public final BooleanPath lock = createBoolean("lock");

    public final NumberPath<Integer> matchCnt = createNumber("matchCnt", Integer.class);

    public final StringPath memberLoc = createString("memberLoc");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath password = createString("password");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath userId = createString("userId");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

