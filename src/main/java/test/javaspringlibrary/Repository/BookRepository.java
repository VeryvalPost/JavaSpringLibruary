package test.javaspringlibrary.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.javaspringlibrary.Entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthors_NameContainingAndTitleContaining(String author, String title);
    List<Book> findByAuthors_NameContaining(String author);
    List<Book> findByTitleContaining(String title);
}