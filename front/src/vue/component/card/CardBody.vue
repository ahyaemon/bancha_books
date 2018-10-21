<template>
    <div class="siimple-card-body"><slot></slot></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class CardBody extends Vue {}
</script>