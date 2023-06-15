package org.ncu.spring_jdbc_app.controller;


import java.util.List;

import org.ncu.spring_jdbc_app.entity.Book;
import org.ncu.spring_jdbc_app.service.BookService;
import org.ncu.spring_jdbc_app.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	
	//inject EmployeeService bean into EmployeeeController bean
	@Autowired
	private BookService bookService;
	
	
	
	
	//to enable data binding --- method to return entity bean
	@ModelAttribute(name="book")
	public Book getBook() {
		return new Book();
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)   //--generic mapping
	//@GetMapping(value = "/form") ...... equivalent of above line -- specific mapping
	//method to return the input form	
	public String getBookForm() {
		return "book-form";
		
	}

	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	//@PostMapping(value = "/process")
	//method to process input form
	public String processBookForm(@ModelAttribute("book") Book book) {
		
		if(bookService.createRecord(book) == 1 ) {
			return "confirmation";
		}else {
			return "redirect:/";
		}
	
	}
	
	/*
	@RequestMapping(value = "/show")
	public String showBooks(@ModelAttribute("book") Book book,BindingResult bindingResult,Model model) {
		BookServiceImpl s = new BookServiceImpl();
		model.addAttribute("books", s.sortList());
		return "book-list";
	}
	*/
	
	
	@RequestMapping(value = "/show")
	public String showBooks(Model model) {
		List<Book> books = bookService.fetchRecords();
		model.addAttribute("books", books);
		return "book-list";
		
		
	}
	
	
	
	@RequestMapping(value = "/show-sorted")
	public String showSortedBooks(Model model) {
		List<Book> books = bookService.sortList();
		model.addAttribute("books", books);
		return "book-list";
	}
	
	
	@RequestMapping(value = "/update")
	public String updateBook(Model model) {
		return "update-form";
	}
	
	@RequestMapping(value = "/update-process", method = RequestMethod.POST)
	public String updateProcess(@ModelAttribute("book") Book book) {
		System.out.println("Inside update-process");
		if(bookService.updateRecord(book) == 1 ) {
			return "update-confirm";
		}else {
			return "redirect:/";
		}
	
	}
	
	
	
	@RequestMapping(value = "/delete")
	public String deleteBook(Model model) {
		return "delete-form";
	}
	
	@RequestMapping(value = "/delete-process", method = RequestMethod.POST)
	public String deleteProcess(@ModelAttribute("book") Book book) {
		System.out.println("Inside delete-process");
		if(bookService.deleteRecord(book) == 1 ) {
			return "delete-confirm";
		}else {
			return "redirect:/";
		}
	
	}
	
	
	@RequestMapping(value = "/search")
	public String searchBook(Model model) {
		return "search-form";
	}
	
	@RequestMapping(value = "/search-process", method = RequestMethod.POST)
	public String searchProcess(@ModelAttribute("book") Book book, Model model) {
		int id = book.getBookId();
		System.out.println("ID = " + id);
		
		Book books = bookService.readRecord(id);
		
		
		if(books != null ) {
			model.addAttribute("book1", books);
			System.out.println("Inside controller, List = " + books);
			
			return "search-list";
		}else {
			return "redirect:/";
		}
		
		
		/*
		Book book_record = bookService.readRecord(id);
		//model.addAttribute("bookss", book_record);
		return "search-list";
		*/
		
	
	}
	
	
	
	@RequestMapping(value="/Backup-confirm" , method = RequestMethod.POST)
	public String batchBookForm() {
		List<Book> books = bookService.fetchRecords();
			
		bookService.batchRecordInsert(books);
		return "Backup-confirm";
	}
	
	
	

}



