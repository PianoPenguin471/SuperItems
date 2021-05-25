package pianopenguin471.items;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SuperZapper extends SuperItem {
	public SuperZapper() {
		this.itemName = "Super Zapper 3000";
		this.itemLore = Arrays.asList("Kaboom? Yes Rico, Kaboom!");
		this.itemMaterial = Material.SHEARS;
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
	
	public void LeftClickBlock(PlayerInteractEvent event) {
		Block clickedBlock = event.getClickedBlock();
		Player player = event.getPlayer();
		player.setAllowFlight(true);
		player.setCustomName("Zappp");
		player.setPlayerListName("Zapp");
		this.telekinisisDestroy(clickedBlock, player);
	}
}
