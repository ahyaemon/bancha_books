package com.volundes.bancha.infra.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-13T07:08:31.413+0900")
public class SentenceDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.volundes.bancha.infra.dao.SentenceDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.SentenceDao.class, "selectBookSummaryByBookId", int.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.SentenceDao.class, "selectCommentBySentenceId", long.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public SentenceDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<com.volundes.bancha.infra.entity.BookSummaryEntity> selectBookSummaryByBookId(int bookId) {
        entering("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectBookSummaryByBookId", bookId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/SentenceDao/selectBookSummaryByBookId.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._BookSummaryEntity.getSingletonInternal());
            __query.addParameter("bookId", int.class, bookId);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.SentenceDaoImpl");
            __query.setCallerMethodName("selectBookSummaryByBookId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.volundes.bancha.infra.entity.BookSummaryEntity>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.volundes.bancha.infra.entity.BookSummaryEntity>(com.volundes.bancha.infra.entity._BookSummaryEntity.getSingletonInternal()));
            java.util.List<com.volundes.bancha.infra.entity.BookSummaryEntity> __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectBookSummaryByBookId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectBookSummaryByBookId", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<com.volundes.bancha.infra.entity.CommentEntity> selectCommentBySentenceId(long sentenceId) {
        entering("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectCommentBySentenceId", sentenceId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/SentenceDao/selectCommentBySentenceId.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._CommentEntity.getSingletonInternal());
            __query.addParameter("sentenceId", long.class, sentenceId);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.SentenceDaoImpl");
            __query.setCallerMethodName("selectCommentBySentenceId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.volundes.bancha.infra.entity.CommentEntity>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.volundes.bancha.infra.entity.CommentEntity>(com.volundes.bancha.infra.entity._CommentEntity.getSingletonInternal()));
            java.util.List<com.volundes.bancha.infra.entity.CommentEntity> __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectCommentBySentenceId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.SentenceDaoImpl", "selectCommentBySentenceId", __e);
            throw __e;
        }
    }

}
