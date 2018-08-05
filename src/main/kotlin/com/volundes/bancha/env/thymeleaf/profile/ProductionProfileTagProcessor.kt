package com.volundes.bancha.env.thymeleaf.profile

class ProductionProfileTagProcessor: ProfileTagProcessor({ it == "production" })