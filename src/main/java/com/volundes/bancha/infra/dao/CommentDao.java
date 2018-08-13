package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.CommentEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface CommentDao {
    @Insert
    @Transactional
    int insert(CommentEntity entity);

    @Select
    @Transactional
    List<CommentEntity> select();

    @Select
    @Transactional
    String selectDeleteKeyByCommentId(Long commentId);

    @Select
    @Transactional
    CommentEntity selectCommentByCommentId(Long commentId);

    @Delete
    @Transactional
    int delete(CommentEntity entity);
}
