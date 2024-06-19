package com.campusMatch.CM.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardData is a Querydsl query type for BoardData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardData extends EntityPathBase<BoardData> {

    private static final long serialVersionUID = 230303964L;

    public static final QBoardData boardData = new QBoardData("boardData");

    public final com.campusMatch.CM.util.QBase _super = new com.campusMatch.CM.util.QBase(this);

    public final NumberPath<Integer> boardDataNum = createNumber("boardDataNum", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> likes = createNumber("likes", Integer.class);

    public final StringPath memberId = createString("memberId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QBoardData(String variable) {
        super(BoardData.class, forVariable(variable));
    }

    public QBoardData(Path<? extends BoardData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardData(PathMetadata metadata) {
        super(BoardData.class, metadata);
    }

}

