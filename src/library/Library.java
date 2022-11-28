package library;

import java.util.ArrayList;

import books.Book;
import books.Exemplar;

import users.User;
import users.Professor;
import users.StudentGrad;
import users.StudentPosGrad;

import actions.Borrow;
import actions.Reserve;

public class Library {

	private ArrayList<User> users;

	private ArrayList<Book> books;

	private static Library instance;

	private Library() {
		this.users = new ArrayList<User>();
		this.books = new ArrayList<Book>();

		this.inicializarLivros();
		this.inicializarUsuarios();
	};

	public static Library getInstance() {
		if (instance == null) {
			instance = new Library();
		}
		return instance;
	}

	public void inicializarLivros() {
		Book b1 = new Book(100, "Engenharia de Software", "AddisonWesley",
				"Ian Sommervile", "6ª", "2000", 2);
		books.add(b1);

		Book b2 = new Book(101, "UML - Guia do Usuário", "Campus",
				"Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª",
				"2000", 1);
		books.add(b2);

		Book b3 = new Book(200, "Code Complete", "Microsoft Press",
				"Steve McConnell", "2ª", "2014", 1);
		books.add(b3);

		Book b4 = new Book(201, "Agile SoftwareDevelopment, Principles, Patterns, and Practices",
				"Prentice Hall", "Robert Martin", "1ª", "2002", 1);
		books.add(b4);

		Book b5 = new Book(300, "Refactoring: Improving the Design of Existing Code",
				"AddisonWesley Professional", "Martin Fowler", "1ª", "1999", 2);
		books.add(b5);

		Book b6 = new Book(301, "Software Metrics: A Rigorous and Practical Approach",
				"CRC Press", "Norman Fenton, James Bieman", "3ª", "2014", 0);
		books.add(b6);

		Book b7 = new Book(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
				"AddisonWesley Professional", "Erich Gamma, Richard Helm, RalphJohnson, JohnVlissides",
				"1ª", "1994", 2);
		books.add(b7);

		Book b8 = new Book(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
				"AddisonWesley Professional", "Martin Fowler", "3ª", "2003", 0);
		books.add(b8);

	}

	public void inicializarUsuarios() {
		User prof = new Professor(100, "Carlos Lucena");
		users.add(prof);

		User grad1 = new StudentGrad(123, "João da Silva");
		users.add(grad1);

		User grad2 = new StudentGrad(789, "Pedro Paulo");
		users.add(grad2);

		User pos = new StudentPosGrad(456, "Luiz Fernando Rodrigues");
		users.add(pos);
	}

	public User getUserByCod(int CodUser) {
		for (User user : this.users) {
			if (user.getCod() == CodUser) {
				return user;
			}
		}
		return null;
	}

	public Book getBookByCod(int codBook) {
		for (Book book : this.books) {
			if (book.getCod() == codBook) {
				return book;
			}
		}
		return null;
	}

	public void printBookInfos(int codBook) {
		Book book = this.getBookByCod(codBook);
		if (book == null) {
			System.out.println("LIVRO NAO CADASTRADO");
			return;
		}
		book.printBookInfo();
	}

	public void reserve(int codUser, int codBook) {
		User user = this.getUserByCod(codUser);
		if (user == null) {
			System.out.println("USUARIO NAO CADASTRADO");
			return;
		}
		Book book = this.getBookByCod(codBook);
		if (book == null) {
			System.out.println("LIVRO NAO CADASTRADO");
			return;
		}
		if (user.isAbleToReserve()) {
			new Reserve(user, book);
		}

	}

	public void borrow(int codUser, int codBook) {
		User user = this.getUserByCod(codUser);
		if (user == null) {
			System.out.println("USUARIO NAO CADASTRADO");
			return;
		}
		Book book = this.getBookByCod(codBook);
		if (book == null) {
			System.out.println("LIVRO NAO CADASTRADO");
			return;
		}

		if ((user.isAbleToBorrow(book)) && book.isAbleToBorrow()) {
			Reserve reserve = user.getReserveByBook(book);
			if (reserve != null) {
				reserve.closeReserve();
			}

			new Borrow(user, book.getExemplarToBorrow());
			System.out.println(
					"SUCESSO AO EMPRESTAR O LIVRO: " + book.getTitle()
							+ "AO: " + user.getName());
		}
	}

	public void giveBack(int codUser, int codBook) {
		User user = this.getUserByCod(codUser);
		if (user == null) {
			System.out.println("USUARIO NAO CADASTRADO");
			return;
		}
		Book book = this.getBookByCod(codBook);
		if (book == null) {
			System.out.println("LIVRO NAO CADASTRADO");
			return;
		}

		Borrow borrow = user.getBorrowByBook(book);
		if (borrow == null) {
			System.out.println("NÃO EXISTE EMPRESTIMO DESTE LIVRO PRA ESTE USUARIO");
			return;
		}

		Exemplar exemplar = borrow.getExemplar();
		book.giveBackExemplar(exemplar);

		borrow.finish();

		System.out.println(
				"SUCESSO AO DEVOLVER O LIVRO: " + book.getTitle()
						+ "DE: " + user.getName());
	}
}
