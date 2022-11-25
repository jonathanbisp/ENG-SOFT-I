package users.behaviors;

import java.time.LocalDate;

import books.Book;
import users.User;

public class BorrowProfessor implements BorrowBehavior {

	@Override
	public void borrow(User user, Book book) {

		if (book.getUnborrowedExemplars().size() > book.getBorrowedExemplars().size()) {
			if (user.isDevedor()) {
				user.addBorrowedBook(book.getUnborrowedExemplars().get(0));
				book.setBorrowedExemplars(book.getUnborrowedExemplars().get(0));
				book.removeFromUnborrowedExemplars(book.getUnborrowedExemplars().get(0));
				LocalDate dataDevolucao = LocalDate.now().plusDays(3);
				book.getBorrowedExemplars().get(book.getBorrowedExemplars().size()).setDataDevolucao(dataDevolucao);
				book.getBorrowedExemplars().get(book.getBorrowedExemplars().size()).setDataEmprestimo(LocalDate.now());

				System.out.println("SUCESSO AO EMPRESTAR O LIVRO: " + book.getTitle() + " AO USUARIO: "
						+ user.getName());

				System.out
						.println("SUCESSO AO EMPRESTAR O LIVRO: " + book.getTitle() + " AO USUARIO: " + user.getName());

			}
		} else {
			System.out.println("FALHA AO EMPRESTAR O LIVRO: " + book.getTitle() + " AO USUARIO: " + user.getName());
		}
	}
}
