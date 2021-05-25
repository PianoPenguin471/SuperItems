package pianopenguin471.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pianopenguin471.gui.SuperItemGUI;

public class SuperItemCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("superitems")) {
			if (!(sender instanceof Player))
				return true;
			Player player = (Player) sender;
			SuperItemGUI gui = new SuperItemGUI();
			gui.register();
			gui.openInventory(player);
		}
		return false;
	}
}
