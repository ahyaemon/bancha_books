<template>
    <b-main>
        <th:block th:each="menuItem: ${menuItems}">
            <b-menuitem-blue th:href="${menuItem.url}" th:title="${menuItem.title}" th:subtitle="${menuItem.subtitle}"></b-menuitem-blue>
        </th:block>
    </b-main>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'
    import components from "../component/index"

    @Component({
        components: {...components,}
    })
    export default class MenuPage extends Vue {
        mounted() {
            console.log("book page mounted!!")
        }
    }
</script>