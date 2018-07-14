package com.volundes.bancha.infra.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-12T22:14:10.417+0900")
public final class _CommentEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.volundes.bancha.infra.entity.CommentEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final _CommentEntity __singleton = new _CommentEntity();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the commentId */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, java.lang.Long, Object> $commentId = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(com.volundes.bancha.infra.entity.CommentEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "commentId", "comment_id", __namingType, false, __idGenerator);

    /** the sentenceId */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, java.lang.Long, Object> $sentenceId = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.CommentEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "sentenceId", "sentence_id", __namingType, true, true, false);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, java.lang.String, Object> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.CommentEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "name", "name", __namingType, true, true, false);

    /** the comment */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, java.lang.String, Object> $comment = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.CommentEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "comment", "comment", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.CommentEntity>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __entityPropertyTypeMap;

    private _CommentEntity() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "CommentEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "comment";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __list = new java.util.ArrayList<>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> __map = new java.util.HashMap<>(4);
        __idList.add($commentId);
        __list.add($commentId);
        __map.put("commentId", $commentId);
        __list.add($sentenceId);
        __map.put("sentenceId", $sentenceId);
        __list.add($name);
        __map.put("name", $name);
        __list.add($comment);
        __map.put("comment", $comment);
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
    public void preInsert(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.volundes.bancha.infra.entity.CommentEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.volundes.bancha.infra.entity.CommentEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.CommentEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, ?, ?> getGeneratedIdPropertyType() {
        return $commentId;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.CommentEntity, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.volundes.bancha.infra.entity.CommentEntity newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.volundes.bancha.infra.entity.CommentEntity, ?>> __args) {
        com.volundes.bancha.infra.entity.CommentEntity entity = new com.volundes.bancha.infra.entity.CommentEntity();
        if (__args.get("commentId") != null) __args.get("commentId").save(entity);
        if (__args.get("sentenceId") != null) __args.get("sentenceId").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("comment") != null) __args.get("comment").save(entity);
        return entity;
    }

    @Override
    public Class<com.volundes.bancha.infra.entity.CommentEntity> getEntityClass() {
        return com.volundes.bancha.infra.entity.CommentEntity.class;
    }

    @Override
    public com.volundes.bancha.infra.entity.CommentEntity getOriginalStates(com.volundes.bancha.infra.entity.CommentEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.volundes.bancha.infra.entity.CommentEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _CommentEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _CommentEntity newInstance() {
        return new _CommentEntity();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.CommentEntity> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
