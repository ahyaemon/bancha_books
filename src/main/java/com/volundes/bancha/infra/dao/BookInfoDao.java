package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.BookInfoEntity;
import com.volundes.bancha.infra.entity.table.BookInfoTable;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface BookInfoDao {

    @Select
    List<BookInfoTable> select();

    @Select
    List<BookInfoEntity> selectEntity(SelectOptions selectOptions);

    @Insert
    Result<BookInfoTable> insert(BookInfoTable bookInfoTable);
}
