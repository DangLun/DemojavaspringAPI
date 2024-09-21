package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.FilterParamsDTO;
import com.example.demo.Repos.BookRepo;
import com.example.demo.models.Books;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepo _bookRepo;

    public BookController(BookRepo bookRepo) {
        this._bookRepo = bookRepo;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<Books> getAllBook() {
        return this._bookRepo.findAll();
    }

    @PostMapping("/addBook")
    public @ResponseBody Books addBook(@RequestBody Books book) {
        this._bookRepo.save(book);
        return book;
    }

    @PutMapping("/updateBook")
    public @ResponseBody Books updateBook(@RequestBody Books book) {
        Books existingBook = this._bookRepo.findById(book.getBook_id()).get();

        existingBook.setBook(book);

        this._bookRepo.save(existingBook);

        return existingBook;
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestParam Integer book_id) {
        Books book = this._bookRepo.findById(book_id).get();
        this._bookRepo.delete(book);
        return "Đã xóa thành công sách có id là: " + book.getBook_id();
    }
}
