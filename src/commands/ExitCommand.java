package commands;

import java.util.ArrayList;

public class ExitCommand implements Command {

	@Override
	public void execute(ArrayList<String> args) {
		System.out.println("FECHANDO A BIBLIOTECA PARA SEMPRE...");
		System.exit(0);
	}

}
