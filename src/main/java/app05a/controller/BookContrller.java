package app05a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app05a.domain.Book;
import app05a.domain.Category;
import app05a.srevice.BookService;

@Controller
@RequestMapping("/app05a")
public class BookContrller {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/book_input")
	public String inputBook(Model model){
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		return "app05a/BookAddForm";
	}
	
	@RequestMapping("/book_edit/{id}")
	public String editBook(Model model, @PathVariable long id){
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book", bookService.get(id));
		
		return "app05a/BookEditForm";
	}
	
	@RequestMapping(value="/book_save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book){
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/app05a/book_list";
	}
	
	@RequestMapping(value="/book_update", method=RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book){
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/app05a/book_list";
	}
	
	@RequestMapping(value="/book_list")
	public String listBook(Model model){
		model.addAttribute("books", bookService.getAllBooks());
		return "app05a/BookList";
	}
}
