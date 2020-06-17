package com.diegobiazin.book.service

import com.diegobiazin.book.entity.Book
import com.diegobiazin.book.repository.BookRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun findAll(pageable: Pageable): Iterable<Book> {
        return bookRepository.findAll(pageable)
    }
}