package pianopenguin471.items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.Arrays;

public class LightningWand extends SuperItem {
	public LightningWand() {
		this.itemName = "Lightning Wand";
		this.itemLore = Arrays.asList("Powered by Redstone");
		this.itemMaterial = Material.END_ROD;
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
	
	public void RightClickAir(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location location = player.getEyeLocation();
		Vector direction = location.getDirection().normalize();
		direction.multiply(3);
		player.getWorld().strikeLightning(player.getLocation().add(direction));
		player.sendMessage(ChatColor.DARK_BLUE + "BOOM!");
	}
	
	public void RightClickBlock(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location location = player.getEyeLocation();
		Vector direction = location.getDirection().normalize();
		direction.multiply(3);
		player.getWorld().strikeLightning(player.getLocation().add(direction));
		player.sendMessage(ChatColor.DARK_BLUE + "BOOM!");
		event.setCancelled(true);
	}
}
