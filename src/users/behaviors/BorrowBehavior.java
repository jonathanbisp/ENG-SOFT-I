package users.behaviors;

import books.Book;
import users.User;

public interface BorrowBehavior {

    public boolean isAbleToBorrow(User user, Book book);

}
