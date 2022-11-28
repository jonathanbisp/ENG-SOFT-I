package users;

import java.util.ArrayList;

import actions.Borrow;
import actions.Reserve;
import books.Book;
import users.behaviors.BorrowProfessor;
import users.behaviors.ReserveMaxThree;
import users.observer.Observer;

public class Professor extends User implements Observer{
	
	
	
    public Professor(int cod, String name) {
        this.borrowBehavior = new BorrowProfessor();
        this.reserveBehavior = new ReserveMaxThree();

        this.cod = cod;
        this.name = name;
        this.limitBorrowDays = 7;
        this.notifications = 0;

        this.borrows = new ArrayList<Borrow>();
        this.reserves = new ArrayList<Reserve>();
    }

	@Override
	public void update(Book book) {
		this.notifications++;		
	}

}
