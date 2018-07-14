package com.volundes.bancha.infra.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-11T21:33:37.938+0900")
public class BookDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.volundes.bancha.infra.dao.BookDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.BookDao.class, "insert", com.volundes.bancha.infra.entity.BookEntity.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.BookDao.class, "select");

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.BookDao.class, "selectByIsbn", java.lang.String.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.BookDao.class, "selectByBookId", int.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public BookDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.volundes.bancha.infra.entity.BookEntity entity) {
        entering("com.volundes.bancha.infra.dao.BookDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.volundes.bancha.infra.entity.BookEntity> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.BookDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method0, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.BookDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.BookDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<com.volundes.bancha.infra.entity.BookEntity> select() {
        entering("com.volundes.bancha.infra.dao.BookDaoImpl", "select");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/BookDao/select.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal());
            __query.setCallerClassName("com.volundes.bancha.infra.dao.BookDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.volundes.bancha.infra.entity.BookEntity>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.volundes.bancha.infra.entity.BookEntity>(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal()));
            java.util.List<com.volundes.bancha.infra.entity.BookEntity> __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.BookDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.BookDaoImpl", "select", __e);
            throw __e;
        }
    }

    @Override
    public com.volundes.bancha.infra.entity.BookEntity selectByIsbn(java.lang.String isbn) {
        entering("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByIsbn", isbn);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/BookDao/selectByIsbn.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal());
            __query.addParameter("isbn", java.lang.String.class, isbn);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.BookDaoImpl");
            __query.setCallerMethodName("selectByIsbn");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.volundes.bancha.infra.entity.BookEntity> __command = getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.volundes.bancha.infra.entity.BookEntity>(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal()));
            com.volundes.bancha.infra.entity.BookEntity __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByIsbn", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByIsbn", __e);
            throw __e;
        }
    }

    @Override
    public com.volundes.bancha.infra.entity.BookEntity selectByBookId(int bookId) {
        entering("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByBookId", bookId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/BookDao/selectByBookId.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal());
            __query.addParameter("bookId", int.class, bookId);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.BookDaoImpl");
            __query.setCallerMethodName("selectByBookId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.volundes.bancha.infra.entity.BookEntity> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.volundes.bancha.infra.entity.BookEntity>(com.volundes.bancha.infra.entity._BookEntity.getSingletonInternal()));
            com.volundes.bancha.infra.entity.BookEntity __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByBookId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.BookDaoImpl", "selectByBookId", __e);
            throw __e;
        }
    }

}
