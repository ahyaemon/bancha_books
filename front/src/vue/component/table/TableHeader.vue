<template>
    <div class="siimple-table-header"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class TableHeader extends Vue {}
</script>