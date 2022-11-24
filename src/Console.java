import java.util.HashMap;

import books.Book;
import comands.Comand;
import comands.DevolverComand;
import comands.EmprestarComand;
import comands.LivroComand;
import comands.NtfComand;
import comands.ObservarComand;
import comands.ReservarComand;
import comands.SairComand;
import comands.UsuarioComand;
import users.User;
import users.Professor;

public class Console {
	
	public HashMap<String, Comand> comandos;
	
	public void inicializarComandos() {
		comandos.put("dev", new DevolverComand());
		comandos.put("emp", new EmprestarComand());
		comandos.put("liv", new LivroComand());
		comandos.put("ntf", new NtfComand());
		comandos.put("obs", new ObservarComand());
		comandos.put("res", new ReservarComand());
		comandos.put("sai", new SairComand());
		comandos.put("usu", new UsuarioComand());
	}
	
	
    public static void main(String[] args) {



        Book.printInfosById(100);
        

    }

}
