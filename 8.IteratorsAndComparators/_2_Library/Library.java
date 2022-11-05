package _2_Library;

import java.util.Arrays;
import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int cnt = 0;

        public boolean hasNext() {
            if (cnt < books.length) {
                return true;
            }
            return false;
        }
        public Book next() {
            return books[cnt++];
        }
    }

//    @Override
//    public Iterator<Book> iterator() {
//        return Arrays.stream(books).iterator();
//    }
}
