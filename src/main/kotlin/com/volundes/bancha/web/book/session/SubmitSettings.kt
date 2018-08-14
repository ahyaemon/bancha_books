package com.volundes.bancha.web.book.session

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("submit")
class SubmitSettings{
    var duration: Long = 0
}