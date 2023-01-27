package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookServices {
    
    private static List<Book> list =new ArrayList<>();

    static{
        list.add(new Book(1, "Java Overview", "Shubhra"));
        list.add(new Book(2, "C++ Overview", "Shubhra"));
        list.add(new Book(3, "Python Overview", "Shubhra"));
        list.add(new Book(4, "Kotlin Overview", "Shubhra"));
    }

    //get All books
    public List<Book> getAllBook(){
        return list;
    }

    //get book by id
    public Book getBookById( int id){
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }


    //Adding the book 
    public Book addBook(Book b){

        list.add(b);
        return b;
    }

    public void deleteBook(int bid){
        list = list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
    }
    
    //update book
    public void updateBook(Book book, int bid){
        list.stream().map(b->{
            if (b.getId()==bid) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
