package com.volundes.bancha.infra.dao;

import com.volundes.bancha.domain.general.login.AccountRegister;
import com.volundes.bancha.infra.entity.ProfileEntity;
import com.volundes.bancha.infra.entity.table.AccountRegisterTable;
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
public interface AccountRegisterDao {

    @Select
    @Transactional
    int countUrlKey(String urlKey);

    @Select
    String selectEmailByUrlKey(String urlKey);

    @Insert
    @Transactional
    int insert(AccountRegisterTable entity);

}
