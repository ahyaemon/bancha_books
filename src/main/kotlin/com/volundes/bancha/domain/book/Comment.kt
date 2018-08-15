package com.volundes.bancha.domain.book

data class Comment(
        val commentId: Long?,
        val name: String,
        val comment: String,
        val deleteKey: String?
){

    fun canDelete(): Boolean{
        return deleteKey != null
    }

}