package commands;

import java.util.ArrayList;

import library.Library;

public class NotifyCommand implements Command {

	@Override
	public void execute(ArrayList<String> args) {

		Library library = Library.getInstance();

		int codUser = Integer.parseInt(args.get(0));
		
		library.notify(codUser);
	}

}
