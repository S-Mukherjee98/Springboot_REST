package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookServices {

    @Autowired

    private BookRepository bookRepository;

    // private static List<Book> list =new ArrayList<>();

    // static{
    // list.add(new Book(1, "Java Overview", "Shubhra"));
    // list.add(new Book(2, "C++ Overview", "Shubhra"));
    // list.add(new Book(3, "Python Overview", "Shubhra"));
    // list.add(new Book(4, "Kotlin Overview", "Shubhra"));
    // }

    // get All books
    public List<Book> getAllBook() {

        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Adding the book
    public Book addBook(Book b) {

        Book bk = this.bookRepository.save(b);
        return bk;
    }

    public void deleteBook(int bid) {
        this.bookRepository.deleteById(bid);
    }

    // update book
    public void updateBook(Book book, int bid) {
        book.setId(bid);
        this.bookRepository.save(book);
    }
}
