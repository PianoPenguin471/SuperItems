package pianopenguin471.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.Arrays;

public class EnderBow extends SuperItem {
	public EnderBow() {
		this.itemName = ChatColor.DARK_PURPLE + "Ender Bow";
		this.itemMaterial = Material.BOW;
		this.itemLore = Arrays.asList("Shoot an ender pearl instead of an arrow");
	}
	
	public void EnderBow(EntityShootBowEvent event) {
		Player player = (Player) event.getEntity();
		Entity arrow = event.getProjectile();
		EnderPearl pearl = player.launchProjectile(EnderPearl.class, arrow.getVelocity());
		arrow.remove();
		pearl.setShooter(player);
	}
}
