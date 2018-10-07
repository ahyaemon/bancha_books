package com.volundes.bancha.infra.dao;

import com.volundes.bancha.infra.entity.CommentCountedSentenceEntity;
import com.volundes.bancha.infra.entity.table.SentenceTable;
import com.volundes.bancha.infra.entity.SentenceSummaryEntity;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.SelectOptions;
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
    List<SentenceTable> select();

    @Select
    List<SentenceSummaryEntity> selectSentenceSummaryBySentenceId(Long sentenceId, SelectOptions selectOptions);

    @Select
    int countSentenceByBookId(Long bookId);

    @Select
    List<CommentCountedSentenceEntity> countSentenceComment(List<Long> sentenceIds);

    @BatchInsert
    int[] insert(List<SentenceTable> entities);

}
