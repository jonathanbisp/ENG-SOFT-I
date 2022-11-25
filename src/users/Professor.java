package users;

import users.behaviors.BorrowProfessor;
import users.behaviors.ReserveMaxThree;
import books.Book;
import books.Exemplar;

import java.util.ArrayList;

public class Professor extends User {
    public Professor(int cod, String name) {
        this.borrowBehavior = new BorrowProfessor();
        this.reserveBehavior = new ReserveMaxThree();

        this.cod = cod;
        this.name = name;

        this.borrowedBooks = new ArrayList<Exemplar>();
        this.reservedBooks = new ArrayList<Book>();

        users.add(this);
    }

}
