package com.campusMatch.CM.meeting.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QApply is a Querydsl query type for Apply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApply extends EntityPathBase<Apply> {

    private static final long serialVersionUID = 1187226021L;

    public static final QApply apply = new QApply("apply");

    public final com.campusMatch.CM.util.QBase _super = new com.campusMatch.CM.util.QBase(this);

    public final StringPath birthDate = createString("birthDate");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath dirPath = createString("dirPath");

    public final StringPath fileName1 = createString("fileName1");

    public final StringPath fileName2 = createString("fileName2");

    public final StringPath fileName3 = createString("fileName3");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> groupCnt = createNumber("groupCnt", Integer.class);

    public final StringPath kakaoId = createString("kakaoId");

    public final StringPath kakaoUrl = createString("kakaoUrl");

    public final StringPath loc = createString("loc");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final StringPath userId = createString("userId");

    public QApply(String variable) {
        super(Apply.class, forVariable(variable));
    }

    public QApply(Path<? extends Apply> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApply(PathMetadata metadata) {
        super(Apply.class, metadata);
    }

}

