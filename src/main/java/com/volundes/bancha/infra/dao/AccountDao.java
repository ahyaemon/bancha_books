package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.AccountEntity;
import com.volundes.bancha.infra.entity.table.AccountTable;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface AccountDao {

    @Select
    List<AccountTable> select();

    @Select
    AccountTable selectByName(String name);

    @Select
    AccountEntity selectEntityById(Long accountId);

    @Select
    AccountEntity selectEntityByEmail(String email);

    @Insert
    Result<AccountTable> insert(AccountTable table);

    @Update
    Result<AccountTable> update(AccountTable accountTable);

}
