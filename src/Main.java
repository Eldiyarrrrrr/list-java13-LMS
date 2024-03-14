import enums.Gender;
import enums.Genre;
import models.Book;
import models.Reader;
import service.LibraryService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**    Models
         models.Library(id, name, address, List<models.Book>books, List<models.Reader>readers)
         models.Book(id, name, author, Genre genre)
         models.Reader(id, fullName, email, phoneNumber, Gender gender)
         models.Database(List<models.Library>libraries, List<models.Book>books,List<models.Reader>readers)


         2. Methods



         LibraryService
         List<models.Library>saveLibrary(List<models.Library>libraries);

         List<models.Library>getAllLibraries();

         models.Library getLibraryById(Long id);

         models.Library updateLibrary(Long id, models.Library library);

         String deleteLibrary(Long id);



         BookService
         models.Book saveBook(Long libraryId,models.Book book);

         List<models.Book>getAllBooks(Long libraryId);

         models.Book getBookById(Long libraryId, Long bookId);

         String deleteBook(Long libraryId,Long bookId);

         void clearBooksByLibraryId(Long libraryId);



         ReaderService
         void saveReader(Reader reader);

         List<models.Reader> getAllReaders();

         models.Reader getReaderById(Long id);

         models.Reader updateReader(Long id, Reader reader);

         void assignReaderToLibrary(Long readerId,Long libraryId);



         Бардык методдор Main класска чакырылып, switch case аркылуу ирээттуу турдо консольго чыксын   **/

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        LibraryService libraryService = new LibraryServiceImpl();


        Reader reader = new Reader();
        Book book = new Book();
        reader.setId(1);
        reader.setFullname("eldiyar avazbekov");
        reader.setEmail("eldiyar@gmail.com");
        reader.setPhoneNumber(500190406L);
        reader.setGender(Gender.MALE);

        while (true) {
            System.out.println("""
                    1. Book
                    2. Library
                    3. Reader
                    """);
            switch (scanner1.nextInt()) {
                case 1 -> {
                    System.out.println("""
                            1. saveBook
                            2. getAllBooks
                            3. getBookById
                            4. updateBook
                            5. assignBookToLibrary
                            """);
                    int choice = scanner1.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Write book's name: ");
                            book.setName(scanner2.nextLine());
                            System.out.println("Write book's id: ");
                            book.setId(scanner1.nextLong());
                            System.out.println("Write author's name: ");
                            book.setAuthor(scanner2.nextLine());
                            System.out.println("Write book's genre: " + Arrays.toString(Genre.values()));
                            book.setGenre(Genre.valueOf(scanner2.nextLine()));
                            bookService.saveBook(book.getId(), book);

                        }
                        case 2 -> {
                            System.out.println(bookService.getAllBooks(scanner1.nextLong()));


                        }
                    }
                }
            }
        }
//                case 2 -> {
//
//                }
//                case 3 -> {
//                    boolean a = true;
//                    while (a){
//                        System.out.println("""
//                                1. saveReader
//                                2. getAllReaders
//                                3. getReaderById
//                                4. updateReader
//                                5. assignReaderToLibrary
//                                """);
//                        switch (scanner.nextInt()){
//                            case 1 -> {
//
//                                readerService.saveReader(reader);
//                            }
//                            case 2 -> {
//
//                            }
//                            case 3 -> {
//
//                            }
//                            case 4 -> {
//
//                            }
//                            case 5 -> {
//
//                            }
//                        }
//                    }
//                }
//            }
//        }


    }
}
