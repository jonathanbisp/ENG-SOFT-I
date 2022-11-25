package books;

import java.time.LocalDate;

import users.User;

public class Exemplar {
	private int cod;
	private User borrower;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	public Exemplar(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public String getBorrowerName() {
		return this.borrower.getName();
	}
	
	public int getBorrowerCod() {
		return this.borrower.getCod();
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
}