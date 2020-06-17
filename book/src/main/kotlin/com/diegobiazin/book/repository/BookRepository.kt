package com.diegobiazin.book.repository

import com.diegobiazin.book.entity.Book
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface BookRepository : PagingAndSortingRepository<Book, UUID> {
}