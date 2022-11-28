package users;

import books.Book;
import users.behaviors.BorrowBehavior;
import users.behaviors.ReserveBehavior;

import java.time.LocalDate;
import java.util.ArrayList;

import actions.Borrow;
import actions.Reserve;

public abstract class User {
	BorrowBehavior borrowBehavior;
	ReserveBehavior reserveBehavior;

	int cod;
	String name;
	int limitBorrowDays;
	int notifications;

	ArrayList<Borrow> borrows;
	ArrayList<Reserve> reserves;

	User() {

	}

	public int amountActiveBorrowedBooks() {
		int amountActiveBorrows = 0;

		for (Borrow borrow : this.borrows) {
			if (borrow.isActive()) {
				amountActiveBorrows += 1;
			}
		}
		return amountActiveBorrows;
	}

	public int getLimitBorrowDays() {
		return limitBorrowDays;
	}

	public int getCod() {
		return this.cod;
	}

	public String getName() {
		return this.name;
	}

	public boolean isAbleToBorrow(Book book) {
		return this.borrowBehavior.isAbleToBorrow(this, book);
	}

	public boolean isAbleToReserve() {
		return this.reserveBehavior.isAbleToReserve(this);
	}

	public boolean isDebtor() {
		for (Borrow borrow : this.borrows) {
			if (!borrow.isActive()) {
				if (LocalDate.now().isAfter(borrow.getExpectedReturnDate())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isActiveBorrowedBook(Book book) {
		for (Borrow borrow : this.borrows) {
			if ((borrow.isActive()) && (borrow.getExemplar().getBook() == book)) {
				return true;
			}
		}
		return false;
	}

	public boolean isActiveReservedBook(Book book) {
		for (Reserve reserve : this.reserves) {
			if ((reserve.isActive()) && (reserve.getBook() == book)) {
				return true;
			}
		}
		return false;
	}

	public void addBorrow(Borrow borrow) {
		this.borrows.add(borrow);
	}

	public int amountReservedBook() {
		return this.reserves.size();
	}

	public void addReserve(Reserve reserve) {
		this.reserves.add(reserve);
	}

	public Reserve getReserveByBook(Book book) {
		for (Reserve reserve : this.reserves) {
			if ((reserve.isActive()) && (reserve.getBook() == book)) {
				return reserve;
			}
		}
		return null;
	}

	public Borrow getBorrowByBook(Book book) {
		for (Borrow borrow : this.borrows) {
			if ((borrow.isActive()) && borrow.getExemplar().getBook() == book) {
				return borrow;
			}
		}
		return null;
	}

    public int getNotifications() {
		return notifications;
	}

	public void printUserInfo() {

		if (this.borrows.size() > 0) {
			System.out.println("Emprestimos:");
			for (Borrow borrow : this.borrows) {
				System.out.println("   " + borrow.getExemplar().getBook().getTitle());
				System.out.println("   " + borrow.getBorrowDate());
				if (borrow.getReturnDate() == null) {
					System.out.println("   " + borrow.getExpectedReturnDate());
				} else
					System.out.println("   " + borrow.getReturnDate());
				if (borrow.isActive()) {
					System.out.println("   " + "Em Curso");
				} else
					System.out.println("   " + "Finalizado");

			}
			if (this.reserves.size() > 0) {
				System.out.println("Reservas:");
				for (Reserve reserve : this.reserves) {
					System.out.println("   " + reserve.getBook().getTitle());
					System.out.println("   " + reserve.getSolicitationDate());
				}
			}
		}
	}

}
