package books;

import java.util.ArrayList;
import java.util.stream.IntStream;

import actions.Reserve;
import users.User;

public class Book {

    private int cod;
    private String title;

    // private String editor;
    // private String authors;
    // private String edition;
    // private String releaseYear;

    private ArrayList<Reserve> reserves;

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

        this.reserves = new ArrayList<Reserve>();

        this.unborrowedExemplars = new ArrayList<Exemplar>();
        IntStream.range(1, amountExemplars + 1).forEach(
                exemplarCod -> this.unborrowedExemplars.add(new Exemplar(exemplarCod, this)));

        this.borrowedExemplars = new ArrayList<Exemplar>();
    }

    public String getTitle() {
        return title;
    }

    public void addReserve(Reserve reserve) {
        this.reserves.add(reserve);
    }

    public void printBookInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Titulo: " + this.title);
        System.out.println("Quantidade de reservas: " + this.reserves.size());
        if (this.reserves.size() > 0) {
            System.out.println("Reservado por:");
            for (Reserve reserve : this.reserves) {
                System.out.println("   " + reserve.getUser().getName());
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

    public int getCod() {
        return cod;
    }

    public boolean isAbleToBorrow() {
        if (this.unborrowedExemplars.size() > 0) {
            return true;
        } else {
            System.out.println("FALHA AO EMPRESTAR O LIVRO: " + this.getTitle() +
                    "POIS NÃO HÁ LIVROS DISPONIVEIS");
            return false;
        }
    }

    public Exemplar getExemplarToBorrow() {
        Exemplar exemplar = this.unborrowedExemplars.get(0);
        this.unborrowedExemplars.remove(exemplar);
        this.borrowedExemplars.add(exemplar);
        return exemplar;
    }

    public ArrayList<Exemplar> getUnborrowedExemplars() {
        return unborrowedExemplars;
    }

    public void removeFromBorrowedExemplars(Exemplar exemplar) {
        this.borrowedExemplars.remove(exemplar);
    }

    public ArrayList<Reserve> getReserves() {
        return reserves;
    }

    public boolean isBorrowed(User u) {
        for (Exemplar e : borrowedExemplars) {
            if (e.getBorrowerCod() == u.getCod()) {
                return true;
            }
        }
        return false;
    }

}
