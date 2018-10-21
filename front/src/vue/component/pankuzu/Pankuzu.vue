<template>
    <section class="sec-pankuzu">
        <div class="siimple-breadcrumb bancha-bread">
            <slot></slot>
        </div>
    </section>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Pankuzu extends Vue {
    }
</script>