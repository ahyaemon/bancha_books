package com.volundes.bancha.env.setting

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("display.limit")
class DisplayLimitSettings{

    var book: Int = 5
    var sentence: Int = 10
    var comment: Int = 20

}