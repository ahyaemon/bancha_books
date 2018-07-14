package com.volundes.bancha.infra.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-11T21:36:06.763+0900")
public final class _SentenceEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.volundes.bancha.infra.entity.SentenceEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final _SentenceEntity __singleton = new _SentenceEntity();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the sentenceId */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, java.lang.Long, Object> $sentenceId = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(com.volundes.bancha.infra.entity.SentenceEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "sentenceId", "sentence_id", __namingType, false, __idGenerator);

    /** the bookId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, java.lang.Long, Object> $bookId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "bookId", "book_id", __namingType, true, true, false);

    /** the sentence */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, java.lang.String, Object> $sentence = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.SentenceEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "sentence", "sentence", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.SentenceEntity>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __entityPropertyTypeMap;

    private _SentenceEntity() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "SentenceEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "book";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __list = new java.util.ArrayList<>(3);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __map = new java.util.HashMap<>(3);
        __idList.add($sentenceId);
        __list.add($sentenceId);
        __map.put("sentenceId", $sentenceId);
        __list.add($bookId);
        __map.put("bookId", $bookId);
        __list.add($sentence);
        __map.put("sentence", $sentence);
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
    public void preInsert(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.volundes.bancha.infra.entity.SentenceEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.volundes.bancha.infra.entity.SentenceEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.SentenceEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, ?, ?> getGeneratedIdPropertyType() {
        return $sentenceId;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.SentenceEntity, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.volundes.bancha.infra.entity.SentenceEntity newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.volundes.bancha.infra.entity.SentenceEntity, ?>> __args) {
        com.volundes.bancha.infra.entity.SentenceEntity entity = new com.volundes.bancha.infra.entity.SentenceEntity();
        if (__args.get("sentenceId") != null) __args.get("sentenceId").save(entity);
        if (__args.get("bookId") != null) __args.get("bookId").save(entity);
        if (__args.get("sentence") != null) __args.get("sentence").save(entity);
        return entity;
    }

    @Override
    public Class<com.volundes.bancha.infra.entity.SentenceEntity> getEntityClass() {
        return com.volundes.bancha.infra.entity.SentenceEntity.class;
    }

    @Override
    public com.volundes.bancha.infra.entity.SentenceEntity getOriginalStates(com.volundes.bancha.infra.entity.SentenceEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.volundes.bancha.infra.entity.SentenceEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _SentenceEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _SentenceEntity newInstance() {
        return new _SentenceEntity();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.SentenceEntity> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
