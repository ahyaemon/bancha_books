<template>
    <b-nav-template color="blightgreen">
        <div class="dropdown">
            <a href="javascript:void(0);">
                <div class="general-name" @click="showDropdown2()"> {{ accountName }}さん</div>
            </a>
            <div class="dropdown-content">
                <a :href="'/account/' + accountId">会員ページ</a>
                <hr />
                <a href="/bookmenu">Books</a>
                <a href="/about">About</a>
                <a href="/donation">Donation</a>
                <hr />
                <a href="/general/logout">ログアウト</a>
                <div class="dropdown-up" @click="hideDropdown2()">
                    <i class="fas fa-angle-double-up"></i>
                </div>
            </div>
        </div>
    </b-nav-template>
</template>

<script lang="ts">
    import Vue from 'vue'
    import Component from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'
    import NavTemplate from "./NavTemplate.vue"
    import anime from "animejs"
    import $ from "jquery"

    @Component({
        components: {
            "b-nav-template": NavTemplate
        }
    })
    export default class NavGeneral extends Vue {
        @Prop() accountName!: string
        @Prop() accountId!: string

        private dropdown: any

        mounted() {
            this.dropdown = {
                disabled: true,
                target: '.dropdown-content',
                height: 0,
                init: function(){
                },
                show: function(){
                    var $target = $(this.target);
                    this.height = $target.height();
                    $target.css("top", -this.height);
                    anime({
                        targets: this.target,
                        translateY: this.height,
                        easing: 'easeInOutQuart',
                        duration: 500,
                        direction: 'normal',
                    });
                    this.disabled = false;
                },
                hide: function(){
                    anime({
                        targets: this.target,
                        translateY: -this.height,
                        easing: 'easeInOutQuart',
                        duration: 500,
                        direction: 'normal',
                    });
                    this.disabled = true;
                }
            }
        }

        showDropdown2() {
            this.dropdown.show()
            console.log("show drop down")
        }

        hideDropdown2() {
            this.dropdown.hide()
            console.log("hide drop down")
        }
    }
</script>
