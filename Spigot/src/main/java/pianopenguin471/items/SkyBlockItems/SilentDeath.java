package pianopenguin471.items.SkyBlockItems;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import pianopenguin471.items.SuperItem;

import java.util.Arrays;
import java.util.Collection;

public class SilentDeath extends SuperItem {
	public SilentDeath() {
		this.itemMaterial = Material.IRON_SWORD;
		this.itemName = "Silent Death";
		this.itemLore = Arrays.asList("Ninja Time");
		this.addAbility("Shadowstep", "Teleport behind the enemy you are looking at. Max range of 20 blocks");
	}
	
	@Override
	public void RightClickAir(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Collection<Entity> entities = player.getWorld().getNearbyEntities(player.getLocation(),20,20,20);
		for (int i = 0; i < 20; i++) {
			for (Entity entity : entities) {
				if (entity.getLocation().distance(this.getLocationInFrontOfPlayer(player, i)) < 2) {
					player.teleport(this.getLocationInFrontOfPlayer(entity, -2));
					player.attack(entity);
					return;
				}
			}
		}
		
	}
}
