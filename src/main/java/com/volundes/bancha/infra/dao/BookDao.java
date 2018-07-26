package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.BookEntity;
import com.volundes.bancha.infra.entity.InsertBookEntity;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface BookDao {
    @Insert
    @Transactional
    int insert(InsertBookEntity entity);

    @Select
    @Transactional
    List<BookEntity> select();

    @Select
    @Transactional
    BookEntity selectByIsbn(String isbn);

    @Select
    BookEntity selectByBookId(int bookId);

    @Select
    Long selectBookIdByNameAndAuthor(String name, String author);
}
