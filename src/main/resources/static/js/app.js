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

var app = new Vue({
    el: '#app',
})