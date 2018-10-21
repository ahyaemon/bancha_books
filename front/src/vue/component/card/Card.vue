<template>
    <div class="siimple-card" style="max-width: 800px;">
        <slot></slot>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Card extends Vue {}
</script>