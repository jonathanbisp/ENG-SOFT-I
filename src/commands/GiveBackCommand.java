package commands;

import java.util.ArrayList;
import library.Library;

public class GiveBackCommand implements Command {

	@Override
	public void execute(ArrayList<String> args) {
		Library library = Library.getInstance();

		int codUser = Integer.parseInt(args.get(0));
		int codBook = Integer.parseInt(args.get(1));
		library.giveBack(codUser, codBook);
	}

}
