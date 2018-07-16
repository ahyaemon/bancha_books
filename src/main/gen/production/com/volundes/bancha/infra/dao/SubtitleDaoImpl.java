package com.volundes.bancha.infra.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-17T07:51:26.379+0900")
public class SubtitleDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.volundes.bancha.infra.dao.SubtitleDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.volundes.bancha.infra.dao.SubtitleDao.class, "selectByTitleCd", java.lang.String.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public SubtitleDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<com.volundes.bancha.infra.entity.SubtitleEntity> selectByTitleCd(java.lang.String titleCd) {
        entering("com.volundes.bancha.infra.dao.SubtitleDaoImpl", "selectByTitleCd", titleCd);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/volundes/bancha/infra/dao/SubtitleDao/selectByTitleCd.sql");
            __query.setEntityType(com.volundes.bancha.infra.entity._SubtitleEntity.getSingletonInternal());
            __query.addParameter("titleCd", java.lang.String.class, titleCd);
            __query.setCallerClassName("com.volundes.bancha.infra.dao.SubtitleDaoImpl");
            __query.setCallerMethodName("selectByTitleCd");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.volundes.bancha.infra.entity.SubtitleEntity>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.volundes.bancha.infra.entity.SubtitleEntity>(com.volundes.bancha.infra.entity._SubtitleEntity.getSingletonInternal()));
            java.util.List<com.volundes.bancha.infra.entity.SubtitleEntity> __result = __command.execute();
            __query.complete();
            exiting("com.volundes.bancha.infra.dao.SubtitleDaoImpl", "selectByTitleCd", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.volundes.bancha.infra.dao.SubtitleDaoImpl", "selectByTitleCd", __e);
            throw __e;
        }
    }

}
