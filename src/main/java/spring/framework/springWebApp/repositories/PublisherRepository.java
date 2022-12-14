package spring.framework.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.springWebApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> { }
