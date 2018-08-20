package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.DonationTable;
import com.volundes.bancha.infra.entity.TotalAmountEntity;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface DonationDao {
    @Insert
    @Transactional
    int insert(DonationTable entity);

    @Select
    @Transactional
    TotalAmountEntity sum();

    @Select
    @Transactional
    List<DonationTable> select();
}
