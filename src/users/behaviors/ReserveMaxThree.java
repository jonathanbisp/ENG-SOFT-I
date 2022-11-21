package users.behaviors;

import books.Book;
import users.User;

public class ReserveMaxThree implements ReserveBehavior {

    @Override
    public void reserve(User user, Book book) {
        Integer limit_books = 3;

        if (user.amountReservedBook() < limit_books) {
            user.addReservedBook(book);
            book.AddReserve(user);
            System.out.println("SUCESSO AO RESERVAR O LIVRO: " + book.getTitle() + " AO USUARIO: " + user.getName());
        } else {
            System.out.println("FALHA AO RESERVAR O LIVRO: " + book.getTitle() + " AO USUARIO: " + user.getName());
        }
    }

    @Override
    public void removeReserve(User user, Book book) {

        if (user.isReserverdBook(book)) {
            user.removeReservedBook(book);
            book.removeReserve(user);
        }
    }

}
