package spring.framework.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.framework.springWebApp.domain.Author;
import spring.framework.springWebApp.domain.Book;
import spring.framework.springWebApp.repositories.AuthorRepository;
import spring.framework.springWebApp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
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
