package test.javaspringlibrary.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.javaspringlibrary.Entity.Author;
import test.javaspringlibrary.Entity.Book;
import test.javaspringlibrary.Repository.AuthorRepository;
import test.javaspringlibrary.Repository.BookRepository;

import java.util.List;
import java.util.Set;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> searchBooks(String author, String title) {
        if (author != null && title != null) {
            return bookRepository.findByAuthors_NameContainingAndTitleContaining(author, title);
        } else if (author != null) {
            return bookRepository.findByAuthors_NameContaining(author);
        } else if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else {
            return bookRepository.findAll();
        }
    }

    public void addBook(Book book) {

        // Сохраняем новых авторов перед сохранением книги
        Set<Author> authors = book.getAuthors();
        if (authors != null && !authors.isEmpty()) {
            for (Author author : authors) {
                authorRepository.save(author);
            }
        }
        bookRepository.save(book);
    }

    public void updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthors(book.getAuthors());

        bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + id));

        existingAuthor.setName(author.getName());

        authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}