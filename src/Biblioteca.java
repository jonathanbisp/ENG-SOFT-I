import java.util.ArrayList;

import books.Book;
import users.Professor;
import users.User;

public class Biblioteca {
	
	public ArrayList<User> usuarios;
	
	public ArrayList<Book> livros;
	
	private Biblioteca() {};
	
	private static Biblioteca instance;
	
	public static Biblioteca getInstance() {
		if (instance == null) {
			instance = new Biblioteca();
		}
		return instance;
	}
	
	
	public void inicializarLivros() {
        Book livro = new Book(100, "Engenharia de Software", "AddisonWesley",
                "Ian Sommervile", "6ª", "2000", 2);
        livros.add(livro);
	}
	
	public void inicializarUsuarios() {
        User professor = new Professor(100, "Carlos Lucena");
        usuarios.add(professor);
	}
	

	public void reservar(int codUsuario, int codLivro) {
		for(User u : usuarios) {
			if(u.getCod() == codUsuario) {
				u.reserve(Book.getById(codLivro));
			}
		}
	}
	
	public void emprestar(int codUsuario, int  codLivro) {
		for(User u : usuarios) {
			if(u.getCod() == codUsuario) {
				u.borrow(Book.getById(codLivro));
			}
		}
		
	}
	public void devolver(int codUsuario, int  codLivro) {
		for(User u : usuarios) {
			if(u.getCod() == codUsuario) {
				u.devolver(Book.getById(codLivro));
			}
		}
	}
	
	public void findByBook(int  codLivro) {
		Book.printInfosById(codLivro);
	}
	
	public void findByUser(int codUsuario) {
	}
	}

