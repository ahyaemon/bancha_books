<template>
    <div class="siimple-field">
        <div class="siimple-form-field-label">{{ title }}</div>
        <input class="siimple-input" type="text" :id="inputId" style="width:700px;" />
    </div>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    @Component
    export default class InputText extends Vue {
        @Prop() title!: string
        @Prop() inputId!: string
    }
</script>