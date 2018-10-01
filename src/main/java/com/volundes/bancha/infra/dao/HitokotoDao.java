package com.volundes.bancha.infra.dao;

import com.volundes.bancha.domain.general.profile.Hitokoto;
import com.volundes.bancha.infra.entity.table.HitokotoTable;
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
public interface HitokotoDao {

    @Select
    @Transactional
    List<HitokotoTable> select();

    @Select
    @Transactional
    HitokotoTable selectByAccountId(Long accountId);

    @Insert
    @Transactional
    int insert(HitokotoTable table);

    @Update
    @Transactional
    int update(HitokotoTable table);

    @Delete
    @Transactional
    int delete(HitokotoTable table);

}
