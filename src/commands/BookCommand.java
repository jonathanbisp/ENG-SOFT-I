package commands;

import java.util.ArrayList;

import library.Library;

public class BookCommand implements Command {

	@Override
	public void execute(ArrayList<String> args) {
		Library library = Library.getInstance();
		int codBook = Integer.parseInt(args.get(0));
		library.printBookInfos(codBook);
	}

}
