<template>
    <div class="siimple-alert siimple-alert--warning">
        <slot></slot>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Warning extends Vue {}
</script>