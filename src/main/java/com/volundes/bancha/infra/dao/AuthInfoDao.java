package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.AuthInfoTable;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface AuthInfoDao {

    @Select
    List<AuthInfoTable> select();

    @Select
    AuthInfoTable selectByEmail(String email);

    @Insert
    int insert(AuthInfoTable table);

    @Update
    int update(AuthInfoTable authInfoTable);
}
