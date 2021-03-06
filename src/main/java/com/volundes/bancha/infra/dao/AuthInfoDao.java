package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.AuthInfoTable;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.Result;
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
    Result<AuthInfoTable> insert(AuthInfoTable table);

    @Update
    Result<AuthInfoTable> update(AuthInfoTable authInfoTable);
}
