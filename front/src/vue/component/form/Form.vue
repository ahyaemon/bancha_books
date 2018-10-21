<template>
    <div class="siimple-form">
        <form :action="action" :method="method">
            <slot></slot>
        </form>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class Form extends Vue {
        @Prop() action!: string
        @Prop() method!: string
    }
</script>