<template>
    <footer>
        <div class="siimple-rule"></div>
        <div class="siimple-footer" align="center">
            <div>
                <a target="_blank" href="https://github.com/ahyaemon/bancha_books">
                    <i class="fab fa-github-square fa-3x"></i>
                </a>
                <a target="_blank" href="https://twitter.com/ahyaemon">
                    <i class="fab fa-twitter-square fa-3x"></i>
                </a>
                <a target="_blank" href="http://ahyaemon.matrix.jp/">
                    <img class="icon" src="/img/ahyaemon.jpg">
                </a>
            </div>
            <div>
                &copy; 2018 Ahyaemon
            </div>
        </div>
    </footer>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'

    @Component
    export default class Footer extends Vue {
    }
</script>