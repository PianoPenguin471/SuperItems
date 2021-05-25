package pianopenguin471.items.SkyBlockItems;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import pianopenguin471.items.SuperItem;

import java.util.Collections;

public class AspectOfTheEnd extends SuperItem {
	private final int teleportDistance = 8;
	public AspectOfTheEnd() {
		this.itemLore = Collections.singletonList("Legal Fly Hacks");
		this.addAbility("Instant Transmission","Teleports you " + teleportDistance + " blocks ahead of you.");
	}
	public void RightClickAir(PlayerInteractEvent event) {
		this.aoteTeleport(event);
	}
	
	public void RightClickBlock(PlayerInteractEvent event) {
		this.aoteTeleport(event);
	}
	
	private void aoteTeleport(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location location = player.getEyeLocation();
		Vector direction = location.getDirection();
		World world = player.getWorld();
		Location location1;
		int distance = this.teleportDistance;
		for (int i = 1; i <= this.teleportDistance; i++) {
			location1 = this.getLocationInFrontOfPlayer(player,i);
			if (!(world.getBlockAt(location1).isPassable())) {
				player.sendMessage(ChatColor.DARK_BLUE + "There are blocks in the way.");
				distance = i-1;
				break;
			}
		}
		player.teleport(location.add(direction.multiply(distance)));
	}
}
