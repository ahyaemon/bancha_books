import Vue from "vue"
import components from "./vue/component/index"
import pages from "./vue/page/index"
new Vue({
    el: "#app",
    components: {
        ...components,
        ...pages,
    },
})
