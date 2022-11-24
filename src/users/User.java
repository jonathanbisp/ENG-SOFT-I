package users;

import books.Book;
import users.behaviors.BorrowBehavior;
import users.behaviors.ReserveBehavior;

import java.util.ArrayList;

public abstract class User {
    public static ArrayList<User> users = new ArrayList<User>();

    BorrowBehavior borrowBehavior;
    ReserveBehavior reserveBehavior;

    int cod;
    String name;

    ArrayList<Book> borrowedBooks;
    ArrayList<Book> reservedBooks;

    User() {

    }

    public void addReservedBook(Book book) {
        this.reservedBooks.add(book);
    }

    public void removeReservedBook(Book book) {
        this.reservedBooks.remove(book);
    }

    public Boolean isReserverdBook(Book book) {
        return this.reservedBooks.contains(book);
    }

    public int amountReservedBook() {
        return this.reservedBooks.size();
    }

    public int getCod() {
        return this.cod;
    }

    public String getName() {
        return this.name;
    }

    public void borrow(Book book) {
        this.borrowBehavior.borrow(this, book);
    }

    public void reserve(Book book) {
        this.reserveBehavior.reserve(this, book);
    }
    
    public static User getById(int id) {
    	for(User u:users) {
    		if(u.cod == id){
    			return u;
    		}
    	}
		return null;
    }
}
