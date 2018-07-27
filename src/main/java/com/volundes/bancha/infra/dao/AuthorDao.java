package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.AuthorEntity;
import com.volundes.bancha.infra.entity.CommentEntity;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface AuthorDao {
    @Select
    @Transactional
    AuthorEntity selectByName(String name);

    @Insert
    @Transactional
    int insert(AuthorEntity authorEntity);
}
