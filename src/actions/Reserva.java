package actions;

import books.Book;
import users.User;

public class Reserva {
	
	private User user;
	
	private Book book;
	
	public Reserva(User user, Book book) {
		
		this.user = user;
		this.book = book;		
		
	}
	
	
	public Book getBook() {
		return book;
	}
	
	public User getUser() {
		return user;
	}

}
