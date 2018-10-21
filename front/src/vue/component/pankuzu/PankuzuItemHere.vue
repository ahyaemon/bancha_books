<template>
    <div class="siimple-breadcrumb-item here"><a :href="href">{{ content }}</a></div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class PankuzuItemHere extends Vue {
        @Prop() href!: string
        @Prop() content!: string
    }
</script>