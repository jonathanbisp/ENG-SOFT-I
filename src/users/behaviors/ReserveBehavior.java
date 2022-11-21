package users.behaviors;

import users.User;
import books.Book;

public interface ReserveBehavior {

    public void reserve(User user, Book book);

    public void removeReserve(User user, Book book);

}
