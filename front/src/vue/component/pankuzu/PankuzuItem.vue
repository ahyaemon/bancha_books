<template>
    <div class="siimple-breadcrumb-item"><a :href="href">{{ content }}</a></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class PankuzuItem extends Vue {
        @Prop() href!: string
        @Prop() content!: string
    }
</script>