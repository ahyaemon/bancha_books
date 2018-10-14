/**
 * メニューとかの四角いリスト(青)
 */
Vue.component('b-menuitem-blue', {
    props:[
        "href",
        "title",
        "subtitle"
    ],
    template: '\
    <a :href="href" class="list-a">\
        <div class="siimple-card bancha-card bancha-back-blue">\
            <div class="siimple-card-body">\
                <div class="siimple-card-title">{{ title }}</div>\
                <div class="siimple-card-subtitle">{{ subtitle }}</div>\
            </div>\
        </div>\
    </a>'
})

/**
 * メニューとかの四角いリスト(黄色)
 */
Vue.component('b-menuitem-yellow', {
    props:[
        "href",
        "title",
        "subtitle"
    ],
    template: '\
    <a :href="href" class="list-a">\
        <div class="siimple-card bancha-card bancha-back-yellow">\
            <div class="siimple-card-body">\
                <div class="siimple-card-title">{{ title }}</div>\
                <div class="siimple-card-subtitle">{{ subtitle }}</div>\
            </div>\
        </div>\
    </a>'
})

/**
 * メニューとかの四角いリスト(黄色 & お気に入りボタン付き)
 */
Vue.component('b-menuitem-yellow-favorite', {
    props:[
        "href",
        "title",
        "subtitle"
    ],
    template: '\
    <a :href="href" class="list-a">\
        <div class="siimple-card bancha-card bancha-back-yellow">\
            <div class="siimple-card-body">\
                <div style="float: left; margin-right: 10px;">\
                    <i class="fas fa-star fa-3x" style="color: #aaa;"></i>\
                </div>\
                <div style="float: left;">\
                    <div class="siimple-card-title">{{ title }}</div>\
                    <div class="siimple-card-subtitle">{{ subtitle }}</div>\
                </div>\
                <div style="clear: both;"></div>\
            </div>\
        </div>\
    </a>'
})

/**
 * パンくずアイテム
 */
Vue.component('b-pankuzu-item', {
    props: [
        "href",
        "content"
    ],
    template: `\
    <div class="siimple-breadcrumb-item"><a :href="href">{{ content }}</a></div>\
    `
})

/**
 * パンくずアイテム（そのページ）
 */
Vue.component('b-pankuzu-hereitem', {
    props: [
        "href",
        "content"
    ],
    template: `\
    <div class="siimple-breadcrumb-item here"><a :href="href">{{ content }}</a></div>\
    `
})

/**
 * パンくずの囲い
 */
Vue.component('b-pankuzu', {
    template: '\
    <section class="sec-pankuzu">\
        <div class="siimple-breadcrumb bancha-bread">\
            <slot></slot>\
        </div>\
    </section>\
    '
})

/**
 * 注意書き
 */
Vue.component('b-warning', {
    template: '\
    <div class="siimple-alert siimple-alert--warning">\
        <slot></slot>\
    </div>\
    '
})

/**
 * ただの p 要素
 */
Vue.component('b-p', {
    template: '\
    <p class="siimple-p">\
        <slot></slot>\
    </p>\
    '
})

/**
 * ナビ
 */
Vue.component('b-header', {
    template: '\
    '
})

/**
 * タイトル
 */
Vue.component('b-nabi', {
    template: '\
    '
})

 /**
  * メイン
  */
 Vue.component('b-main', {
    template: '\
    <section class="sec-content">\
    <slot></slot>\
    </section>\
    '
})

/**
 * フッター
 */
Vue.component('b-footer', {
    template: '\
    <footer>\
        <div class="siimple-rule"></div>\
        <div class="siimple-footer" align="center">\
            <div>\
                <a target="_blank" href="https://github.com/ahyaemon/bancha_books">\
                    <i class="fab fa-github-square fa-3x"></i>\
                </a>\
                <a target="_blank" href="https://twitter.com/ahyaemon">\
                    <i class="fab fa-twitter-square fa-3x"></i>\
                </a>\
                <a target="_blank" href="http://ahyaemon.matrix.jp/">\
                    <img class="icon" src="/img/ahyaemon.jpg">\
                </a>\
            </div>\
            <div>\
                &copy; 2018 Ahyaemon\
            </div>\
        </div>\
    </footer>\
    '
})

/**
 * ナビ: テンプレ
 */
Vue.component('b-nav-template', {
    template: '\
    <section class="sec-header">\
        <div class="siimple-navbar siimple-navbar--fluid blightgreen">\
            <a class="siimple-navbar-title white" href="/">Bancha</a>\
            <a class="siimple-navbar-subtitle white" href="/">v0.2.0</a>\
            <div class="siimple--float-right">\
            <slot></slot>\
            </div>\
        </div>\
    </section class="sec-header">\
    '
})

/**
 * ナビ: 一般
 */
Vue.component('b-nav-general', {
    props: [
        "logged-in"
    ],
    template: '\
        <b-nav-general_login v-if="loggedIn == \'true\'"></b-nav-general_login>\
        <b-nav-general_not_login v-else></b-nav-general_not_login>\
    '
})

/**
 * ナビ: 一般 & 未ログイン
 */
Vue.component('b-nav-general_not_login', {
    template: '\
    <b-nav-template>\
        <a class="siimple-navbar-item white" href="/general/login">Sign in</a>\
    </b-nav-template>\
    '
})


/**
 * ナビ: 一般 & ログイン
 */
Vue.component('b-nav-general_login', {
    props: [
        "account-name",
        "account-id"
    ],
    template: '\
    <b-nav-template>\
        <div class="dropdown">\
            <a href="javascript:void(0);">\
                <div class="general-name" onclick="showDropdown()"> {{ accountName }}さん</div>\
            </a>\
            <div class="dropdown-content">\
                <a :href="\'/account/\' + accountId">会員ページ</a>\
                <hr />\
                <a href="/bookmenu">Books</a>\
                <a href="/about">About</a>\
                <a href="/donation">Donation</a>\
                <hr />\
                <a href="/general/logout">ログアウト</a>\
                <div class="dropdown-up" onclick="hideDropdown()">\
                    <i class="fas fa-angle-double-up"></i>\
                </div>\
            </div>\
        </div>\
    </b-nav-template>\
    '
})


/**
 * ナビ: 管理者 & 未ログイン
 */

/**
 * ナビ: 管理者 & ログイン
 */



var app = new Vue({
    el: '#app',
})