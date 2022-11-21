package books;

import java.util.ArrayList;
import java.util.stream.IntStream;

import users.User;

public class Book {
    public static ArrayList<Book> books = new ArrayList<Book>();

    private int cod;
    private String title;

    // private String editor;
    // private String authors;
    // private String edition;
    // private String releaseYear;

    private ArrayList<User> reserves;

    private ArrayList<Exemplar> unborrowedExemplars;

    private ArrayList<Exemplar> borrowedExemplars;

    public Book(int cod, String title, String editor, String authors, String edition, String releaseYear,
            int amountExemplars) {
        this.cod = cod;
        this.title = title;
        // this.editor = editor;
        // this.authors = authors;
        // this.edition = edition;
        // this.releaseYear = releaseYear;

        this.reserves = new ArrayList<User>();

        this.unborrowedExemplars = new ArrayList<Exemplar>();
        IntStream.range(1, amountExemplars + 1).forEach(
                exemplarCod -> this.unborrowedExemplars.add(new Exemplar(exemplarCod)));

        this.borrowedExemplars = new ArrayList<Exemplar>();

        books.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void AddReserve(User user) {
        this.reserves.add(user);
    }

    public void removeReserve(User user) {
        this.reserves.remove(user);
    }

    public void printBookInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Titulo: " + this.title);
        System.out.println("Quantidade de reservas: " + this.reserves.size());
        if (this.reserves.size() > 0) {
            System.out.println("Reservado por:");
            for (User reserve : this.reserves) {
                System.out.println("   " + reserve.getName());
            }
        }
        System.out.println("Exemplares:");
        for (Exemplar exemplar : this.unborrowedExemplars) {
            System.out.println("   " + exemplar.getCod() + " - Disponivel");
        }
        for (Exemplar exemplar : this.borrowedExemplars) {
            System.out.println("   " + exemplar.getCod() + " - Indsponivel - " + exemplar.getBorrowerName());
        }

    }

    public static Book getById(int cod) {
        for (Book book : books) {
            if (book.cod == cod) {
                return book;
            }
        }
        return null;
    }

    public static void printInfosById(int cod) {
        Book book = Book.getById(cod);
        if (book == null) {
            System.out.println("Livro não cadastrado.");
        } else {
            book.printBookInfo();
        }
    }
}
