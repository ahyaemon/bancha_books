<template>
    <div class="b-jumbotron" :class="color">
        <div class="b-jumbotron-title" style="float: left;">{{ title }}</div>
        <slot></slot>
        <div style="clear: both;"></div>
        <div class="b-jumbotron-subtitle">{{ subtitle }}</div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator';

    @Component
    export default class TitleTemplate extends Vue {
        @Prop() title!: string
        @Prop() subtitle!: string
        @Prop() color!: string
    }
</script>

<style lang="scss">
@import "siimple/scss/layout/_jumbotron.scss";

.b-jumbotron {
    @extend .siimple-jumbotron;
    @extend .siimple-jumbotron--fluid;
}

.b-jumbotron-title {
    @extend .siimple-jumbotron-title;
    color: white;
}

.b-jumbotron-subtitle {
    @extend .siimple-jumbotron-subtitle;
    color: white;
}

</style>