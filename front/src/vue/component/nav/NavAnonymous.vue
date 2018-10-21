<template>
    <b-nav-template color="blightgreen">
        <a class="siimple-navbar-item white" href="/general/login">Sign in</a>
    </b-nav-template>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import NavTemplate from "./NavTemplate.vue"

    @Component({
        components: {
            "b-nav-template": NavTemplate
        }
    })
    export default class NavAnonymous extends Vue {
    }
</script>