<template>
    <p class="siimple-p"><slot></slot></p>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Paragraph extends Vue {
    }
</script>