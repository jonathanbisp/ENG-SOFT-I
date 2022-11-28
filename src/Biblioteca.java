import java.util.ArrayList;

import books.Book;
import users.Professor;
import users.User;

import actions.Borrow;
import actions.Reserve;

public class Biblioteca {

	public ArrayList<User> users;

	public ArrayList<Book> books;

	private Biblioteca() {
	};

	private static Biblioteca instance;

	public static Biblioteca getInstance() {
		if (instance == null) {
			instance = new Biblioteca();
		}
		return instance;
	}

	public User getUserByCod(int cod) {
		for (User user : this.users) {
			if (user.getCod() == cod) {
				return user;
			}
		}
		return null;
	}

	public Book getBookByCod(int cod) {
		for (Book book : this.books) {
			if (book.getCod() == cod) {
				return book;
			}
		}
		return null;
	}

	public void inicializarLivros() {
		Book livro = new Book(100, "Engenharia de Software", "AddisonWesley",
				"Ian Sommervile", "6ª", "2000", 2);
		books.add(livro);
	}

	public void inicializarUsuarios() {
		User professor = new Professor(100, "Carlos Lucena");
		users.add(professor);
	}

	public void reserve(int codUsuario, int codLivro) {
		User user = this.getUserByCod(codUsuario);
		if (user == null) {
			System.out.println("USUARIO NAO ENCONTRADO");
		}
		Book book = this.getBookByCod(codLivro);
		if (book == null) {
			System.out.println("LIVRO NAO ENCONTRADO");
		}
		if (user.isAbleToReserve()) {
			new Reserve(user, book);
		}

	}

	public void borrow(int codUsuario, int codLivro) {
		User user = this.getUserByCod(codUsuario);
		if (user == null) {
			System.out.println("USUARIO NAO ENCONTRADO");
		}
		Book book = this.getBookByCod(codLivro);
		if (book == null) {
			System.out.println("LIVRO NAO ENCONTRADO");
		}

		if ((user.isAbleToBorrow(book)) && book.isAbleToBorrow()) {
			Reserve reserve = user.getReserveByBook(book);
			reserve.closeReserve();

			new Borrow(user, book.getExemplarToBorrow());
			System.out.println(
					"SUCESSO AO EMPRESTAR O LIVRO: " + book.getTitle()
							+ "AO: " + user.getName());
		}
	}

	// public void devolver(int codUsuario, int codLivro) {
	// User user = this.getUserByCod(codUsuario);
	// if (user == null) {
	// System.out.println("USUARIO NAO ENCONTRADO");
	// }
	// Book book = this.getBookByCod(codLivro);
	// if (book == null) {
	// System.out.println("LIVRO NAO ENCONTRADO");
	// }
	// }

	public void findByBook(int codLivro) {
		Book book = this.getBookByCod(codLivro);
		if (book != null) {
			book.printBookInfo();
		} else {
			System.out.println("LIVRO INEXISTENTE");
		}

	}

	public void findByUser(int codUsuario) {
	}
}
