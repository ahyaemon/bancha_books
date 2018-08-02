package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.*;
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
    int insert(BookEntity entity);

    @Select
    @Transactional
    List<InsertBookEntity> select();

    @Select
    @Transactional
    List<BookMenuEntity> selectBookMenu();

    @Select
    Long selectBookIdByNameAndAuthorId(String name, Long authorId);

    @Select
    List<BookSummaryEntity> selectBookSummaryByBookId(Long bookId);

    @Select
    List<BookInfoEntity> selectBookInfos();
}
