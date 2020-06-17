package com.diegobiazin.book.controller

import com.diegobiazin.book.entity.Book
import com.diegobiazin.book.service.BookService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/admin/books")
class BookController (private val bookService: BookService) {

    @GetMapping
    fun findAll(pageable : Pageable): ResponseEntity<Iterable<Book>> {
        return ResponseEntity(bookService.findAll(pageable), HttpStatus.OK)
    }
}