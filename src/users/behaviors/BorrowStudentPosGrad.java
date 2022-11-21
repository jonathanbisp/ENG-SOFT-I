package users.behaviors;

import java.time.LocalDate;

import books.Book;
import users.User;

public class BorrowStudentPosGrad implements BorrowBehavior {

    @Override
    public void borrow(User user, Book book) {

    }

	@Override
	public LocalDate defineDataDevolucao() {
		LocalDate dataDevolucao =  LocalDate.now().plusDays(4);
		return dataDevolucao;
	}
    
   

}
