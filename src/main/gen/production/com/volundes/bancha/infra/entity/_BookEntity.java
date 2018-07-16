package com.volundes.bancha.infra.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.19.2" }, date = "2018-07-16T12:45:47.677+0900")
public final class _BookEntity extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.volundes.bancha.infra.entity.BookEntity> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.2");
    }

    private static final _BookEntity __singleton = new _BookEntity();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the bookId */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, java.lang.Long, Object> $bookId = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(com.volundes.bancha.infra.entity.BookEntity.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "bookId", "book_id", __namingType, false, __idGenerator);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, java.lang.String, Object> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.BookEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "name", "name", __namingType, true, true, false);

    /** the author */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, java.lang.String, Object> $author = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.BookEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "author", "author", __namingType, true, true, false);

    /** the isbn */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, java.lang.String, Object> $isbn = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.volundes.bancha.infra.entity.BookEntity.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "isbn", "isbn", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.BookEntity>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __entityPropertyTypeMap;

    private _BookEntity() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "BookEntity";
        __catalogName = "";
        __schemaName = "";
        __tableName = "book";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __list = new java.util.ArrayList<>(4);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> __map = new java.util.HashMap<>(4);
        __idList.add($bookId);
        __list.add($bookId);
        __map.put("bookId", $bookId);
        __list.add($name);
        __map.put("name", $name);
        __list.add($author);
        __map.put("author", $author);
        __list.add($isbn);
        __map.put("isbn", $isbn);
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
    public void preInsert(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.volundes.bancha.infra.entity.BookEntity entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.volundes.bancha.infra.entity.BookEntity> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.volundes.bancha.infra.entity.BookEntity, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, ?, ?> getGeneratedIdPropertyType() {
        return $bookId;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.volundes.bancha.infra.entity.BookEntity, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.volundes.bancha.infra.entity.BookEntity newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.volundes.bancha.infra.entity.BookEntity, ?>> __args) {
        com.volundes.bancha.infra.entity.BookEntity entity = new com.volundes.bancha.infra.entity.BookEntity();
        if (__args.get("bookId") != null) __args.get("bookId").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("author") != null) __args.get("author").save(entity);
        if (__args.get("isbn") != null) __args.get("isbn").save(entity);
        return entity;
    }

    @Override
    public Class<com.volundes.bancha.infra.entity.BookEntity> getEntityClass() {
        return com.volundes.bancha.infra.entity.BookEntity.class;
    }

    @Override
    public com.volundes.bancha.infra.entity.BookEntity getOriginalStates(com.volundes.bancha.infra.entity.BookEntity __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.volundes.bancha.infra.entity.BookEntity __entity) {
    }

    /**
     * @return the singleton
     */
    public static _BookEntity getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _BookEntity newInstance() {
        return new _BookEntity();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.volundes.bancha.infra.entity.BookEntity> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
