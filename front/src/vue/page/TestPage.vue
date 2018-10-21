<template>
    <div id="test-page">
        <b-nav-anonymous></b-nav-anonymous>
        <b-title-general title="Bancha Home" subtitle="test page"></b-title-general>
        <b-pankuzu>
            <b-pankuzu-item-here href="/" content="Home"></b-pankuzu-item-here>
        </b-pankuzu>
        <b-main>
            <div id="test1">
                <button id="bt1" @click="go">Go</button>
                <font-awesome-icon icon="coffee" />
            </div>
        </b-main>
        <b-footer></b-footer>
    </div>
</template>

<style lang="scss">
    $blue: blue;
    #test1 {
        width: 100px;
        height: 100px;
        border: 1px solid $blue;
        border-radius: 4px;
    }
</style>

<script lang="ts">
    /** ANIME */
    import anime from "animejs"

    /** VUE */
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    /** COMPONENTS */
    import TitleGeneral from "../component/title/TitleGeneral.vue"
    import NavAnonymous from "../component/nav/NavAnonymous.vue"
    import Pankuzu from "../component/pankuzu/Pankuzu.vue"
    import PankuzuItemHere from "../component/pankuzu/PankuzuItemHere.vue"
    import Warning from "../component/warning/Warning.vue"
    import Paragraph from "../component/basic/Paragraph.vue"
    import Main from "../component/layout/Main.vue"
    import MenuitemBlue from "../component/menuitem/MenuitemBlue.vue"
    import Footer from "../component/layout/Footer.vue"

    @Component({
        components: {
            "b-nav-anonymous": NavAnonymous,
            "b-title-general": TitleGeneral,
            "b-pankuzu": Pankuzu,
            "b-pankuzu-item-here": PankuzuItemHere,
            "b-warning": Warning,
            "b-p": Paragraph,
            "b-main": Main,
            "b-menuitemBlue": MenuitemBlue,
            "b-footer": Footer,
        }
    })
    export default class TestPage extends Vue {
        go() {
            anime({
            targets: '#test1',
            translateX: [
                { value: 100, duration: 1200 },
                { value: 0, duration: 800 }
            ],
            rotate: 'bt1',
            backgroundColor: '#FFF',
            duration: 2000,
            loop: false
            });
        }
    }
</script>