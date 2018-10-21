<template>
    <div class="siimple-table-row"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Row extends Vue {}
</script>