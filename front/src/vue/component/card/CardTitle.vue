<template>
    <div class="siimple-card-title">
        <slot></slot>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class CardTitle extends Vue {}
</script>