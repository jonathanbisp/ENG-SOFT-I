package actions;

import java.time.LocalDate;

import books.Book;
import users.User;

public class Reserve {

	private User user;
	private Book book;
	private Boolean active;
	private LocalDate solicitationDate;

	public Reserve(User user, Book book) {
		this.user = user;
		this.book = book;
		this.active = true;
		this.solicitationDate = LocalDate.now();

		book.addReserve(this);
		user.addReserve(this);
	}

	public Boolean isActive() {
		return active;
	}

	public void closeReserve() {
		active = false;
	}

	public Book getBook() {
		return book;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getSolicitationDate() {
		return solicitationDate;
	}

}
