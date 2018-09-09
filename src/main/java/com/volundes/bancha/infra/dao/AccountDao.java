package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.ProfileEntity;
import com.volundes.bancha.infra.entity.table.AccountTable;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface AccountDao {

    @Insert
    @Transactional
    int insert(AccountTable table);

    @Select
    @Transactional
    AccountTable selectByName(String name);

    @Update
    @Transactional
    int update(AccountTable accountTable);

    @Select
    @Transactional
    ProfileEntity selectProfileByAccountId(Long accountId);

}
