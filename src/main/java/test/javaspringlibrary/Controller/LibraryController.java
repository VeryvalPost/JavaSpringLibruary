package test.javaspringlibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.javaspringlibrary.Entity.Author;
import test.javaspringlibrary.Entity.Book;
import test.javaspringlibrary.Service.LibraryService;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

// Страница по умолчанию
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String author,
                                                  @RequestParam(required = false) String title) {
        List<Book> books = libraryService.searchBooks(author, title);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        libraryService.updateBook(id, book);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @PostMapping("/authors")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        libraryService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author added successfully");
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        libraryService.updateAuthor(id, author);
        return ResponseEntity.ok("Author updated successfully");
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        libraryService.deleteAuthor(id);
        return ResponseEntity.ok("Author deleted successfully");
    }
}