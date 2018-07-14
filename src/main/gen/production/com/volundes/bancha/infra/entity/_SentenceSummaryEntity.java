package com.volundes.bancha.infra.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-13T07:08:31.254+0900")
public final class _SentenceSummaryEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.volundes.bancha.infra.entity.SentenceSummaryEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final _SentenceSummaryEntity __singleton = new _SentenceSummaryEntity();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    /** the sentenceId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.Long, Object> $sentenceId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "sentenceId", "sentence_id", __namingType, true, true, false);

    /** the sentence */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.String, Object> $sentence = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "sentence", "sentence", __namingType, true, true, false);

    /** the commentId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.Long, Object> $commentId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "commentId", "comment_id", __namingType, true, true, false);

    /** the commentName */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.String, Object> $commentName = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "commentName", "comment_name", __namingType, true, true, false);

    /** the comment */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.String, Object> $comment = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "comment", "comment", __namingType, true, true, false);

    /** the rubyId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.Long, Object> $rubyId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "rubyId", "ruby_id", __namingType, true, true, false);

    /** the kanji */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.String, Object> $kanji = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "kanji", "kanji", __namingType, true, true, false);

    /** the ruby */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, java.lang.String, Object> $ruby = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceSummaryEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "ruby", "ruby", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.SentenceSummaryEntity>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __entityPropertyTypeMap;

    private _SentenceSummaryEntity() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "SentenceSummaryEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __list = new java.util.ArrayList<>(8);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __map = new java.util.HashMap<>(8);
        __list.add($sentenceId);
        __map.put("sentenceId", $sentenceId);
        __list.add($sentence);
        __map.put("sentence", $sentence);
        __list.add($commentId);
        __map.put("commentId", $commentId);
        __list.add($commentName);
        __map.put("commentName", $commentName);
        __list.add($comment);
        __map.put("comment", $comment);
        __list.add($rubyId);
        __map.put("rubyId", $rubyId);
        __list.add($kanji);
        __map.put("kanji", $kanji);
        __list.add($ruby);
        __map.put("ruby", $ruby);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.volundes.bancha.infra.entity.SentenceSummaryEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.volundes.bancha.infra.entity.SentenceSummaryEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.volundes.bancha.infra.entity.SentenceSummaryEntity newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.volundes.bancha.infra.entity.SentenceSummaryEntity, ?>> __args) {
        com.volundes.bancha.infra.entity.SentenceSummaryEntity entity = new com.volundes.bancha.infra.entity.SentenceSummaryEntity();
        if (__args.get("sentenceId") != null) __args.get("sentenceId").save(entity);
        if (__args.get("sentence") != null) __args.get("sentence").save(entity);
        if (__args.get("commentId") != null) __args.get("commentId").save(entity);
        if (__args.get("commentName") != null) __args.get("commentName").save(entity);
        if (__args.get("comment") != null) __args.get("comment").save(entity);
        if (__args.get("rubyId") != null) __args.get("rubyId").save(entity);
        if (__args.get("kanji") != null) __args.get("kanji").save(entity);
        if (__args.get("ruby") != null) __args.get("ruby").save(entity);
        return entity;
    }

    @Override
    public Class<com.volundes.bancha.infra.entity.SentenceSummaryEntity> getEntityClass() {
        return com.volundes.bancha.infra.entity.SentenceSummaryEntity.class;
    }

    @Override
    public com.volundes.bancha.infra.entity.SentenceSummaryEntity getOriginalStates(com.volundes.bancha.infra.entity.SentenceSummaryEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.volundes.bancha.infra.entity.SentenceSummaryEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _SentenceSummaryEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _SentenceSummaryEntity newInstance() {
        return new _SentenceSummaryEntity();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.SentenceSummaryEntity> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
