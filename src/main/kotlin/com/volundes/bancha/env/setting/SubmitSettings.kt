package com.volundes.bancha.env.setting

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("submit")
class SubmitSettings{
    var duration: Long = 0
}