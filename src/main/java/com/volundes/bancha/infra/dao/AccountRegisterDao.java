package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.AccountRegisterTable;
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
    int countUrlKey(String urlKey);

    @Select
    String selectEmailByUrlKey(String urlKey);

    @Insert
    int insert(AccountRegisterTable entity);

}
