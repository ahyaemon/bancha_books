<template>
    <b-title-template color="bred" :title="title" :subtitle="subtitle"></b-title-template>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator';
    import TitleTemplate from "./TitleTemplate.vue"

    @Component({
        components: {
            "b-title-template": TitleTemplate,
        }
    })
    export default class TitleAdmin extends Vue {
        @Prop() title!: string
        @Prop() subtitle!: string
    }
</script>