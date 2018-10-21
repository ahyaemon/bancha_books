<template>
    <section class="sec-header">
        <div class="siimple-navbar siimple-navbar--fluid" :class="color">
            <a class="siimple-navbar-title white" href="/">Bancha</a>
            <a class="siimple-navbar-subtitle white" href="/">v0.2.0</a>
            <div class="siimple--float-right">
            <slot></slot>
            </div>
        </div>
    </section>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class NavTemplate extends Vue {
        @Prop() color!: string
    }
</script>