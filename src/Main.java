import enums.Gender;
import enums.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.LibraryService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scannerString = new Scanner(System.in);
        Scanner scannerLong = new Scanner(System.in);
        Scanner scannerDelete = new Scanner(System.in);
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
            switch (scannerLong.nextInt()) {
                case 1 -> {
                    System.out.println("""
                            1. saveBook
                            2. getAllBooks
                            3. getBookById
                            4. deleteBook
                            5. clearBooksByLibraryId
                            """);
                    String choice = scannerString.nextLine();
                    switch (choice) {
                        case "1", "eldiyar" -> {
                            System.out.println("Write book's name: ");
                            book.setName(scannerString.nextLine());
                            System.out.println("Write book's id: ");
                            book.setId(scannerLong.nextLong());
                            System.out.println("Write author's name: ");
                            book.setAuthor(scannerString.nextLine());
                            System.out.println("Write book's genre: " + Arrays.toString(Genre.values()));
                            book.setGenre(Genre.valueOf(scannerString.nextLine()));
                            bookService.saveBook(book.getId(), book);

                        }
                        case "2", "eldiyayaa" -> {
                            System.out.println(bookService.getAllBooks());
                        }
                        case "3", "eldiya" -> {
                            System.out.println(bookService.getBookById(scannerLong.nextLong(), scannerLong.nextLong()));
                        }
                        case "4", "eldiy" -> {
                            System.out.println(bookService.deleteBook(scannerDelete.nextLong(), scannerDelete.nextLong()));
                        }
                        case "5", "eldi" -> {
                            bookService.clearBooksByLibraryId(scannerLong.nextLong());
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("""
                                1. saveLibrary
                                2. getAllLibraries
                                3. getLibraryById
                                4. updateLibrary
                                5. deleteLibrary
                                6. Exit
                                """);
                        int command = scannerLong.nextInt();
                        switch (command) {
                            case 1 -> {

                                Library library = new Library();
                                System.out.println("Id jazynyz: ");
                                library.setId(scannerLong.nextLong());
                                System.out.println("Name jazynyz: ");
                                library.setName(scannerString.nextLine());
                                System.out.println("Address jazynyz: ");
                                library.setAddress(scannerString.nextLine());

                                System.out.println(libraryService.saveLibrary(library));
                            }
                            case 2 -> {
                                System.out.println(libraryService.getAllLibraries());
                            }
                            case 3 -> {
                                System.out.println(libraryService.getLibraryById(scannerLong.nextLong()));
                            }
                            case 4 -> {
                                Library libraryssss = new Library();
                                System.out.println("Osgorto turchu ID jazynyz: ");
                                long libraryId = scannerLong.nextLong();

                                System.out.println("Jany ID jazynyz: ");
                                libraryssss.setId(scannerLong.nextLong());
                                System.out.println("Jany name jazynzy: ");
                                libraryssss.setName(scannerString.nextLine());
                                System.out.println("Jany adress jazynyz: ");
                                libraryssss.setAddress(scannerString.nextLine());
                                System.out.println(libraryService.updateLibrary(libraryId, libraryssss));
                            }
                            case 5 -> {
                                System.out.println(libraryService.deleteLibrary(scannerLong.nextLong()));
                            }
                        }
                        if (command == 6) {
                            break;
                        }
                    }
                }
                case 3 -> {
                    while (true) {
                        System.out.println("""
                                1. saveReader
                                2. getAllReaders
                                3. getReaderById
                                4. updateReader
                                5. assignReaderToLibrary
                                6. Exit
                                """);
                        int choice = scannerLong.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.println(" ID jazynyz: ");
                                reader.setId(scannerLong.nextLong());
                                System.out.println("Name jazynzy: ");
                                reader.setFullname(scannerString.nextLine());
                                System.out.println(" adress jazynyz: ");
                                reader.setEmail(scannerString.nextLine());
                                System.out.println("Phone number jazynyz: ");
                                reader.setPhoneNumber(scannerLong.nextLong());
                                System.out.println("Gender jazynyz: MALE, FEMALE");
                                if (scannerString.nextLine().equalsIgnoreCase("M")) {
                                    reader.setGender(Gender.MALE);
                                } else if (scannerString.nextLine().equalsIgnoreCase("F")) {
                                    reader.setGender(Gender.FEMALE);
                                }
                                readerService.saveReader(reader);
                            }
                            case 2 -> {
                                System.out.println(readerService.getAllReaders());
                            }
                            case 3 -> {
                                System.out.println(readerService.getReaderById(scannerLong.nextLong()));
                            }
                            case 4 -> {
                                System.out.println("Osgorto turchu ID jazynyz: ");
                                long readerId = scannerLong.nextLong();
                                System.out.println("Jany ID jazynyz: ");
                                reader.setId(scannerLong.nextLong());
                                System.out.println("Jany Fullname jazynyz: ");
                                reader.setFullname(scannerString.nextLine());
                                System.out.println("Jany Email jazynyz: ");
                                reader.setEmail(scannerString.nextLine());
                                System.out.println("Jany Phone number jazynyz: ");
                                reader.setPhoneNumber(scannerLong.nextLong());
                                System.out.println("Jany Gender jazynyz: ");
                                if (scannerString.nextLine().equalsIgnoreCase("M")) {
                                    reader.setGender(Gender.MALE);
                                } else if (scannerString.nextLine().equalsIgnoreCase("F")) {
                                    reader.setGender(Gender.FEMALE);
                                }
                                System.out.println(readerService.updateReader(readerId, reader));
                            }
                            case 5 -> {
                                readerService.assignReaderToLibrary(scannerLong.nextLong(),scannerLong.nextLong());
                            }



                        }
                    }
                }
            }
        }


    }
}
