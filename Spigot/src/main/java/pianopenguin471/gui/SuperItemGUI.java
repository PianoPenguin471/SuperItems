package pianopenguin471.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pianopenguin471.SuperItems;
import pianopenguin471.items.SuperItem;

public class SuperItemGUI {
	private static Inventory INV;
	
	public void setInventory(Inventory inv) {
		SuperItemGUI.INV = inv;
	}
	
	public void register() {
		int size = 9;
		while (SuperItems.items.size() > size) {
			size += 9;
		}
		Inventory inv = Bukkit.createInventory(null, size, ChatColor.AQUA + "" + ChatColor.BOLD + "Super Items");
		int num = 0;
		for (SuperItem customItem: SuperItems.items) {
			inv.setItem(num,customItem.getItem());
			num++;
		}
		
		
		setInventory(inv);
	}
	
	public void openInventory(Player player) {
		player.openInventory(INV);
	}
}
