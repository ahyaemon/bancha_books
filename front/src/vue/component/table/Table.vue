<template>
    <div class="siimple-table"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Table extends Vue {}
</script>