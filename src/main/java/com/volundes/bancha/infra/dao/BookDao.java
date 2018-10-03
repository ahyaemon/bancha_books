package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.*;
import com.volundes.bancha.infra.entity.table.BookTable;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface BookDao {

    @Select
    @Transactional
    List<BookTable> select();

    @Select
    @Transactional
    List<BookInfoEntity> selectBookInfoWithPaging(SelectOptions selectOptions);

    @Select
    Long selectBookIdByNameAndAuthorId(String name, Long authorId);

    @Select
    List<BookSummaryEntity> selectBookSummaryByBookId(Long bookId, SelectOptions selectOptions);

    @Select
    Integer countBook();

    @Insert
    @Transactional
    int insert(BookTable entity);

}
