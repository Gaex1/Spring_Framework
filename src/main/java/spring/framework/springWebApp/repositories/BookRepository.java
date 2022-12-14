package spring.framework.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.springWebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
