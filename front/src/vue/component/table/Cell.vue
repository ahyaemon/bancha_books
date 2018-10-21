<template>
    <div class="siimple-table-cell"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Cell extends Vue {}
</script>