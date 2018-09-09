package com.volundes.bancha.env.setting

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("smtp")
class SmtpSettings {

    var password = "pass"

}