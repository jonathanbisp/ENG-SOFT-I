import books.Book;
import users.User;
import users.Professor;

public class Main {
    public static void main(String[] args) {
        Book livro = new Book(100, "Engenharia de Software", "AddisonWesley",
                "Ian Sommervile", "6ª", "2000", 2);

        User professor = new Professor(100, "Carlos Lucena");
        professor.reserve(livro);

        Book.printInfosById(100);

    }

}
