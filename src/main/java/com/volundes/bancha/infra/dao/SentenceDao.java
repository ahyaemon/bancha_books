package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.table.SentenceTable;
import com.volundes.bancha.infra.entity.SentenceSummaryEntity;
import org.seasar.doma.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
@Dao
public interface SentenceDao {

    @Select
    @Transactional
    List<SentenceTable> select();

    @Select
    List<SentenceSummaryEntity> selectSentenceSummaryBySentenceId(Long sentenceId);

    @BatchInsert
    @Transactional
    int[] insert(List<SentenceTable> entities);

}
