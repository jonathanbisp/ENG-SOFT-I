package books;

import actions.Borrow;

public class Exemplar {
	private int cod;
	private Borrow borrow;
	private Book book;

	public Exemplar(int cod, Book book) {
		this.cod = cod;
		this.book = book;
	}

	public int getCod() {
		return cod;
	}

	public Book getBook() {
		return book;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public String getBorrowerName() {
		return this.borrow.getUser().getName();
	}

	public int getBorrowerCod() {
		return this.borrow.getUser().getCod();
	}
}