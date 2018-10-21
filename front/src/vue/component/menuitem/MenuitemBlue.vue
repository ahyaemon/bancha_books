<template>
    <a :href="href" class="list-a">
        <div class="siimple-card bancha-card bancha-back-blue">
            <div class="siimple-card-body">
                <div class="siimple-card-title">{{ title }}</div>
                <div class="siimple-card-subtitle">{{ subtitle }}</div>
            </div>
        </div>
    </a>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class NavTemplate extends Vue {
        @Prop() href!: string
        @Prop() title!: string
        @Prop() subtitle!: string
    }
</script>