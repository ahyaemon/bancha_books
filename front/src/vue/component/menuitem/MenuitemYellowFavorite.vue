<template>
    <a :href="href" class="list-a">
        <div class="siimple-card bancha-card bancha-back-yellow">
            <div class="siimple-card-body">
                <div style="float: left; margin-right: 10px;">
                    <i class="fas fa-star fa-3x" style="color: #aaa;"></i>
                </div>
                <div style="float: left;">
                    <div class="siimple-card-title">{{ title }}</div>
                    <div class="siimple-card-subtitle">{{ subtitle }}</div>
                </div>
                <div style="clear: both;"></div>
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