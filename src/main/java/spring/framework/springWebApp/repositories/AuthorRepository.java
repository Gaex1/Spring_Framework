package spring.framework.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.springWebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
