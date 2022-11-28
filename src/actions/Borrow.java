package actions;

import books.Exemplar;
import users.User;

import java.time.LocalDate;

public class Borrow {

    private User user;
    private Exemplar exemplar;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate expectedReturnDate;

    public Borrow(User user, Exemplar exemplar) {
        this.user = user;
        this.exemplar = exemplar;
        this.borrowDate = LocalDate.now();
        this.expectedReturnDate = LocalDate.now().plusDays(user.getLimitBorrowDays());

        user.addBorrow(this);
        exemplar.setBorrow(this);
    }

    public void setReturnDate() {
        this.returnDate = LocalDate.now();
    }

    public Boolean isActive() {
        if (this.returnDate == null) {
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

}
