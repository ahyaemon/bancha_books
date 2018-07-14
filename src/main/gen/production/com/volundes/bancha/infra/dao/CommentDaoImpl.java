package com.volundes.bancha.infra.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-12T22:11:12.834+0900")
public class CommentDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.volundes.bancha.infra.dao.CommentDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.CommentDao.class, "insert", com.volundes.bancha.infra.entity.CommentEntity.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CommentDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public int insert(com.volundes.bancha.infra.entity.CommentEntity entity) {
        entering("com.volundes.bancha.infra.dao.CommentDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<com.volundes.bancha.infra.entity.CommentEntity> __query = getQueryImplementors().createAutoInsertQuery(__method0, com.volundes.bancha.infra.entity._CommentEntity.getSingletonInternal());
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.CommentDaoImpl");
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
            exiting("com.volundes.bancha.infra.dao.CommentDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.CommentDaoImpl", "insert", __e);
            throw __e;
        }
    }

}
