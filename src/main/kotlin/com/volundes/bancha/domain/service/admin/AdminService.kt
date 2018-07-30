package com.volundes.bancha.domain.service.admin

import com.volundes.bancha.domain.dto.Csv
import com.volundes.bancha.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class AdminService(
        private val bookRepository: BookRepository
) {

    fun getDataList(): List<Data>{
        // commentEntityで試す
        val data1 = getCommentData("comment1")
        val data2 = getCommentData("comment2")
        return arrayListOf(data1, data2)
    }

    private fun getCommentData(filename: String): Data{
        val commentEntities = bookRepository.getCommentEntities()
        val titles = Record(arrayListOf("comment_id", "sentence_id", "name", "comment"))
        val records = commentEntities.map{
            Record(arrayListOf(it.commentId.toString(), it.sentenceId.toString(), it.name, it.comment))
        }
        return Data(filename, titles, records)
    }

}