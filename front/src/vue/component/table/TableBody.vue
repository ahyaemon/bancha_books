<template>
    <div class="siimple-table-body"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class TableBody extends Vue {}
</script>