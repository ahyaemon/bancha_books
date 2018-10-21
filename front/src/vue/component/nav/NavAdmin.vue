<template>
    <b-nav-template color="blightred"></b-nav-template>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import NavTemplate from "./NavTemplate.vue"

    @Component({
        components: {
            "b-nav-template": NavAdmin
        }
    })
    export default class NavAdmin extends Vue {}
</script>