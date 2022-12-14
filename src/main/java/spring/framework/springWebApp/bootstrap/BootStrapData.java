package spring.framework.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.framework.springWebApp.domain.Author;
import spring.framework.springWebApp.domain.Book;
import spring.framework.springWebApp.domain.Publisher;
import spring.framework.springWebApp.repositories.AuthorRepository;
import spring.framework.springWebApp.repositories.BookRepository;
import spring.framework.springWebApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Publisher publisher = new Publisher();
        publisher.setCity("roma");
        publisher.setName("mario");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven design", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
