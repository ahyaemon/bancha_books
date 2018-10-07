package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.CommentTable;
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

    @Select
    List<CommentTable> select();

    @Select
    CommentTable selectCommentByCommentId(Long commentId);

    @Select
    Long selectId();

    @Select
    int countCommentBySentenceId(Long sentenceId);

    @Insert
    int insert(CommentTable entity);

    @Delete
    int delete(CommentTable entity);

}
