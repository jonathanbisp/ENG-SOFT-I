package users.behaviors;

import books.Book;
import users.User;

public class BorrowStudentGrad implements BorrowBehavior {

	@Override
	public boolean isAbleToBorrow(User user, Book book) {
		Integer limit_books = 3;

		if (user.isDebtor()) {
			System.out.println("FALHA AO EMPRESTAR AO USUARIO: "
					+ user.getName() + "POIS ELE É DEVEDOR");
			return false;
		}

		if (user.amountActiveBorrowedBooks() >= limit_books) {
			System.out.println("FALHA AO EMPRESTAR AO USUARIO: "
					+ user.getName() +
					"POIS ATINGIU O LIMITE DE LIVROS EMPRESTADOS");
			return false;
		}

		if (user.isActiveBorrowedBook(book)) {
			System.out.println("FALHA AO EMPRESTAR AO USUARIO: "
					+ user.getName() +
					"POIS ELE JA PEGOU O LIVRO EMPRESTADO");
			return false;
		}

		if ((book.getAmountReserves() >= book.getAmountUnborrowedExemplars())
				&& (!user.isActiveReservedBook(book))) {
			System.out.println("FALHA AO EMPRESTAR AO USUARIO: "
					+ user.getName() +
					"POIS NÃO POSSUI POSSUI RESERVA E QUANTIDADE DE RESERVAS É MAIOR QUE A QUANTIDADE DE EXEMPLARES");
			return false;
		}

		return true;
	}

}
