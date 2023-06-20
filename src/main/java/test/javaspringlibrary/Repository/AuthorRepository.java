package test.javaspringlibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.javaspringlibrary.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}