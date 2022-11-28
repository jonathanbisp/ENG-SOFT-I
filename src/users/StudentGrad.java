package users;

import users.behaviors.BorrowProfessor;
import users.behaviors.ReserveMaxThree;
import actions.Borrow;
import actions.Reserve;

import java.util.ArrayList;

public class StudentGrad extends User {
    public StudentGrad(int cod, String name) {
        this.borrowBehavior = new BorrowProfessor();
        this.reserveBehavior = new ReserveMaxThree();

        this.cod = cod;
        this.name = name;
        this.limitBorrowDays = 3;

        this.borrows = new ArrayList<Borrow>();
        this.reserves = new ArrayList<Reserve>();
    }

}
