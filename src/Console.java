import java.util.HashMap;

import books.Book;
import comands.Comand;
import users.User;
import users.Professor;

public class Console {
	
	public HashMap<String, Comand> comandos;
	
	
	
    public static void main(String[] args) {
        Book livro = new Book(100, "Engenharia de Software", "AddisonWesley",
                "Ian Sommervile", "6ª", "2000", 2);

        User professor = new Professor(100, "Carlos Lucena");
        professor.reserve(livro);

        Book.printInfosById(100);
        

    }

}
