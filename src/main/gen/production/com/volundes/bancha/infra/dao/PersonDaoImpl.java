package com.volundes.bancha.infra.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-10T23:19:35.848+0900")
public class PersonDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.volundes.bancha.infra.dao.PersonDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.PersonDao.class, "insert", com.volundes.bancha.infra.entity.PersonEntity.class);

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.PersonDao.class, "select");

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.PersonDao.class, "update", com.volundes.bancha.infra.entity.PersonEntity.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.PersonDao.class, "delete", com.volundes.bancha.infra.entity.PersonEntity.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public PersonDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.volundes.bancha.infra.entity.PersonEntity entity) {
        entering("com.volundes.bancha.infra.dao.PersonDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.volundes.bancha.infra.entity.PersonEntity> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.volundes.bancha.infra.entity._PersonEntity.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.PersonDaoImpl");
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
            exiting("com.volundes.bancha.infra.dao.PersonDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.PersonDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<com.volundes.bancha.infra.entity.PersonEntity> select() {
        entering("com.volundes.bancha.infra.dao.PersonDaoImpl", "select");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/PersonDao/select.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._PersonEntity.getSingletonInternal());
            __query.setCallerClassName("com.volundes.bancha.infra.dao.PersonDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.volundes.bancha.infra.entity.PersonEntity>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.volundes.bancha.infra.entity.PersonEntity>(com.volundes.bancha.infra.entity._PersonEntity.getSingletonInternal()));
            java.util.List<com.volundes.bancha.infra.entity.PersonEntity> __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.PersonDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.PersonDaoImpl", "select", __e);
            throw __e;
        }
    }

    @Override
    public int update(com.volundes.bancha.infra.entity.PersonEntity entity) {
        entering("com.volundes.bancha.infra.dao.PersonDaoImpl", "update", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoUpdateQuery<com.volundes.bancha.infra.entity.PersonEntity> __query = getQueryImplementors().createAutoUpdateQuery(__method2, com.volundes.bancha.infra.entity._PersonEntity.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.PersonDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.PersonDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.PersonDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(com.volundes.bancha.infra.entity.PersonEntity entity) {
        entering("com.volundes.bancha.infra.dao.PersonDaoImpl", "delete", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoDeleteQuery<com.volundes.bancha.infra.entity.PersonEntity> __query = getQueryImplementors().createAutoDeleteQuery(__method3, com.volundes.bancha.infra.entity._PersonEntity.getSingletonInternal());
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.PersonDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.PersonDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.PersonDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
