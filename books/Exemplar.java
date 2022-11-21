package books;

import users.User;

public class Exemplar {
    private int cod;
    private User borrower;

    public Exemplar(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public String getBorrowerName() {
        return this.borrower.getName();
    }
}
