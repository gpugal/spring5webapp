/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookReposoitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pugal
 */
@Controller
public class BookController {
    
    public final BookReposoitory bookReposoitory;

    public BookController(BookReposoitory bookReposoitory) {
        this.bookReposoitory = bookReposoitory;
    }
            
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookReposoitory.findAll());
        return "books/list";
    }
    
}
