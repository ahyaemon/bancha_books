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
Vue.component('b-pankuzu-item-here', {
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
    props: [
        "color"
    ],
    template: '\
    <section class="sec-header">\
        <div class="siimple-navbar siimple-navbar--fluid" :class="color">\
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
 * ナビ: 一般 & 未ログイン
 */
Vue.component('b-nav-general_not_login', {
    template: '\
    <b-nav-template color="blightgreen">\
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
    <b-nav-template color="blightgreen">\
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
 * ナビ: 管理者 & ログイン
 */
Vue.component('b-nav-admin', {
    props: [
        "account-name",
        "account-id"
    ],
    template: '\
    <b-nav-template color="blightred"></b-nav-template>\
    '
})

/**
 * タイトル: テンプレ
 */
Vue.component('b-title-template', {
    props: [
        "title",
        "subtitle",
        "color"
    ],
    template: '\
    <div class="siimple-jumbotron siimple-jumbotron--fluid" :class="color">\
        <div class="siimple-jumbotron-title white" style="float: left;">{{ title }}</div>\
        <slot></slot>\
        <div style="clear: both;"></div>\
        <div class="siimple-jumbotron-subtitle white">{{ subtitle }}</div>\
    </div>\
    '
})

/**
 * タイトル: 一般
 */
Vue.component('b-title-general', {
    props: [
        "title",
        "subtitle"
    ],
    template: '\
        <b-title-template color="bgreen" :title="title" :subtitle="subtitle"></b-title-template>\
    '
})

/**
 * タイトル: 一般（お気に入りボタン付き）
 */
Vue.component('b-title-favorite', {
    props: [
        "title",
        "subtitle"
    ],
    template: '\
    <b-title-template color="bgreen" :title="title" :subtitle="subtitle">\
        <div style="float: left; margin-left: 10px;">\
            <i class="fas fa-star fa-3x" style="color: #aaa;"></i>\
        </div>\
    </b-title-template>\
    '
})

/**
 * タイトル: Admin
 */
Vue.component('b-title-admin', {
    props: [
        "title",
        "subtitle"
    ],
    template: '\
        <b-title-template color="bred" :title="title" :subtitle="subtitle"></b-title-template>\
    '
})

/**
 * テーブル
 */
Vue.component('b-table', {
    template: '\
    <div class="siimple-table"><slot></slot></div>\
    '
})

/**
 * テーブルヘッダー
 */
Vue.component('b-table-header', {
    template: '\
    <div class="siimple-table-header"><slot></slot></div>\
    '
})

/**
 * テーブルボディ
 */
Vue.component('b-table-body', {
    template: '\
    <div class="siimple-table-body"><slot></slot></div>\
    '
})

/**
 * 行
 */
Vue.component('b-row', {
    template: '\
    <div class="siimple-table-row"><slot></slot></div>\
    '
})

/**
 * セル
 */
Vue.component('b-cell', {
    template: '\
    <div class="siimple-table-cell"><slot></slot></div>\
    '
})

/**
 * カード
 */
Vue.component('b-card', {
    template: '\
    <div class="siimple-card" style="max-width: 800px;">\
        <slot></slot>\
    </div>\
    '
})

/**
 * カードボディ
 */
Vue.component('b-card-body', {
    template: '\
    <div class="siimple-card-body">\
        <slot></slot>\
    </div>\
    '
})

/**
 * カードタイトル
 */
Vue.component('b-card-title', {
    template: '\
    <div class="siimple-card-title">\
        <slot></slot>\
    </div>\
    '
})

/**
 * フォーム
 */
Vue.component('b-form', {
    props: [
        "action",
        "method"
    ],
    template: '\
    <div class="siimple-form">\
        <form :action="action" :method="method">\
            <slot></slot>\
        </form>\
    </div>\
'
})

/**
 * input text
 */
Vue.component('b-input-text', {
    props: [
        "title",
        "input-id"
    ],
    template: '\
    <div class="siimple-field">\
        <div class="siimple-form-field-label">{{ title }}</div>\
        <input class="siimple-input" type="text" :id="inputId" style="width:700px;" />\
    </div>\
'
})



var app = new Vue({
    el: '#app',
})