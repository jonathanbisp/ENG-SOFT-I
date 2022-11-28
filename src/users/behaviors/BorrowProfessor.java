package users.behaviors;

import books.Book;
import users.User;

public class BorrowProfessor implements BorrowBehavior {

	@Override
	public boolean isAbleToBorrow(User user, Book book) {

		if (user.isDebtor()) {
			System.out.println("FALHA AO EMPRESTAR AO USUARIO: " + user.getName() + "POIS ELE É DEVEDOR");
			return false;
		} else {
			return true;
		}
	}
}
