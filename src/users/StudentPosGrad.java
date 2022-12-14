package users;

import users.behaviors.BorrowStudentPosGrad;
import users.behaviors.ReserveMaxThree;
import actions.Borrow;
import actions.Reserve;

import java.util.ArrayList;

public class StudentPosGrad extends User {
    public StudentPosGrad(int cod, String name) {
        this.borrowBehavior = new BorrowStudentPosGrad();
        this.reserveBehavior = new ReserveMaxThree();

        this.cod = cod;
        this.name = name;
        this.limitBorrowDays = 4;

        this.borrows = new ArrayList<Borrow>();
        this.reserves = new ArrayList<Reserve>();
    }

}
