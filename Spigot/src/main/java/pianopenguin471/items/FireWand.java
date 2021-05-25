package pianopenguin471.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FireWand extends SuperItem {
	public FireWand() {
		this.itemName = "Fire Wand";
		this.itemLore = Arrays.asList("Powered by Redstone");
		this.itemMaterial = Material.BLAZE_ROD;
	}
	
	public void RightClickAir(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		player.launchProjectile(Fireball.class).setVelocity(player.getLocation().getDirection().multiply(0.5));
		player.sendMessage(ChatColor.DARK_AQUA + "Boom!");
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
	
	public void RightClickBlock(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		player.launchProjectile(Fireball.class).setVelocity(player.getLocation().getDirection().multiply(0.5));
		player.sendMessage(ChatColor.DARK_GREEN + "Boom!");
	}
}
