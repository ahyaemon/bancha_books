package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.CommentTable;
import com.volundes.bancha.infra.entity.table.DeleteKeyTable;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface DeleteKeyDao {

    @Insert
    @Transactional
    int insert(DeleteKeyTable entity);

    @Select
    @Transactional
    List<DeleteKeyTable> select();

    @Select
    @Transactional
    DeleteKeyTable selectByCommentId(Long commentId);

    @Delete
    @Transactional
    int delete(DeleteKeyTable entity);

}
