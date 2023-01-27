package com.api.book.bootrestbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookServices;

@RestController
public class BookController {
   
    @Autowired
    private BookServices bookServices;

    //Get all books handler
    @GetMapping("/book")
    public List<Book> getBooks(){

        return this.bookServices.getAllBook();
    }

    //get book by id handler
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){

        return bookServices.getBookById(id);
    }

    //adding new book handler
    @PostMapping("/book")
    public Book addBook(@RequestBody Book b){
        this.bookServices.addBook(b);
        return b;
    }

    //delete book handler
    @DeleteMapping("/book/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid){
        this.bookServices.deleteBook(bookid);

    }

    //update book handler
    @PutMapping("/book/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int bid){
        this.bookServices.updateBook(book,bid);
        return book;
    } 
}
