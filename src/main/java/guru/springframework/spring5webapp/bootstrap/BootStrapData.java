/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookReposoitory;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author pugal
 */
@Component
public class BootStrapData implements CommandLineRunner{
    
    private final AuthorRepository authorRepository;
    private final BookReposoitory bookReposoitory;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
            BookReposoitory bookReposoitory, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookReposoitory = bookReposoitory;
        this.publisherRepository = publisherRepository;
    }
            
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven", "12123");
        Publisher pp = new Publisher("star Book", "234", "Bangalore", "345323");
        
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        pp.getBooks().add(ddd);
        
        authorRepository.save(eric);
        bookReposoitory.save(ddd);
        publisherRepository.save(pp);
        
        System.out.println("Started in BootStrap");
        System.out.println("No of Books " + bookReposoitory.count());
        System.out.println("No of publisher " + publisherRepository.count());
        System.out.println("No Of books In publiser " + pp.getBooks().size());
    }
    
}
