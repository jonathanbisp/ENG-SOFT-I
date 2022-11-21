package users.behaviors;

import users.User;
import books.Book;

public interface BorrowBehavior {

    public void borrow(User user, Book book);

}
