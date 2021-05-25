package pianopenguin471.items.SkyBlockItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pianopenguin471.items.SuperItem;

import java.util.Arrays;

public class GrapplingHook extends SuperItem {
	public GrapplingHook() {
		this.itemName = ChatColor.GREEN + "Grappling Hook";
		this.itemLore = Arrays.asList("Kaboom? Yes Rico, Kaboom!");
		this.itemMaterial = Material.FISHING_ROD;
	}
	public ItemStack getItem() {
		ItemStack wand = new ItemStack(this.itemMaterial, 1);
		wand.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
		ItemMeta meta = wand.getItemMeta();
		meta.setDisplayName(this.itemName);
		meta.setLore(this.itemLore);
		wand.setItemMeta(meta);
		return wand;
	}
}
