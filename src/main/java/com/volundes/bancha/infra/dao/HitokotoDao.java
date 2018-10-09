package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.HitokotoTable;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface HitokotoDao {

    @Select
    List<HitokotoTable> select();

    @Select
    HitokotoTable selectByAccountId(Long accountId);

    @Insert
    Result<HitokotoTable> insert(HitokotoTable table);

    @Update
    Result<HitokotoTable> update(HitokotoTable table);

    @Delete
    Result<HitokotoTable> delete(HitokotoTable table);

}
