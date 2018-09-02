package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.HitokotoTable;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface HitokotoDao {

    @Select
    @Transactional
    HitokotoTable selectByAccountId(Long accountId);

}
