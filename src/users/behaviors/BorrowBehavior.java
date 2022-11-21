package users.behaviors;

import java.time.LocalDate;

import books.Book;
import users.User;

public interface BorrowBehavior {

    public void borrow(User user, Book book);

    
    public LocalDate defineDataDevolucao();
    
}
