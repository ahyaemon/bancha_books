package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.LicenseTable;
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
public interface LicenseDao {

    @Select
    List<LicenseTable> select();

    @Insert
    int insert(LicenseTable licenseTable);

}
