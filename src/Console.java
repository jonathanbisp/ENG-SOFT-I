import java.util.ArrayList;
import java.util.HashMap;

import commands.Command;
import commands.GiveBackCommand;
import commands.BorrowCommand;
import commands.BookCommand;
import commands.NotifyCommand;
import commands.ObserveComand;
import commands.ReserveCommand;
import commands.ExitCommand;
import commands.UserCommand;

public class Console {

	public HashMap<String, Command> commands = new HashMap<String, Command>();

	public Console() {
		this.initCommands();
	}

	public void initCommands() {

		commands.put("dev", new GiveBackCommand());
		commands.put("emp", new BorrowCommand());
		commands.put("liv", new BookCommand());
		commands.put("ntf", new NotifyCommand());
		commands.put("obs", new ObserveComand());
		commands.put("res", new ReserveCommand());
		commands.put("sai", new ExitCommand());
		commands.put("usu", new UserCommand());
	}

	public void service(String cmd, ArrayList<String> data) {
		Command command = commands.get(cmd);
		command.execute(data);
	}

}
