package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {


    @Test
    void bookServiceFindBookByIdTest() {
        InMemoryBookRepository inMemoryBookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(inMemoryBookRepository);
        Book book = new Book("1", "Book1", "Author1");
        when(inMemoryBookRepository.findById("1")).thenReturn(book);

        bookService.findBookById("1");

        verify(inMemoryBookRepository).findById("1");
        assertEquals(book, bookService.findBookById("1"));
    }

    @Test
    void bookServiceFindAllBooksTest() {
        InMemoryBookRepository inMemoryBookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(inMemoryBookRepository);
        Book book = new Book("1", "Book1", "Author1");
        Book book1 = new Book("2", "Book2", "Author2");
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        when(inMemoryBookRepository.findAll()).thenReturn(bookList);

        bookService.findAllBooks();

        verify(inMemoryBookRepository).findAll();
        assertEquals(bookList, bookService.findAllBooks());
    }

}