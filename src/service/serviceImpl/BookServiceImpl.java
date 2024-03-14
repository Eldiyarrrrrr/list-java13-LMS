package service.serviceImpl;

import models.Book;
import models.Database;
import models.Library;
import service.BookService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for(Library library : Database.libraries){
            if(library.getId() == libraryId){
                library.setBooks(book);

            }
        }
        return book;
    }
    @Override
    public List<Book> getAllBooks(Long libraryId) {
        List<Book> r = new ArrayList<>();
        if (Database.books.getLast().getId() == libraryId) {
            r = Database.books;
        }
        return r;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for(Library library : Database.libraries){
            if(library.getId() == libraryId){
                for(Book book : Database.books){
                    if(book.getId() == bookId){
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for(Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : Database.books) {
                    if (book.getId() == bookId) {
                        Database.books.remove(book);
                        return "A book was deleted.";
                    }
                }
            }
        }
        return null;
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for(Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().clear();
                    }
                }
            }
        }



