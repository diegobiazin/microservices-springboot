package com.diegobiazin.book.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: UUID?,

        @Column
        var author: String?,

        @Column
        var title: String?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}