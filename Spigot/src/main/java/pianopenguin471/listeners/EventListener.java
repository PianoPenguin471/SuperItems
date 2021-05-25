package pianopenguin471.listeners;

import org.bukkit.Location;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import pianopenguin471.SuperItems;
import pianopenguin471.items.EnderBow;
import pianopenguin471.items.SuperItem;

public class EventListener implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Action action = e.getAction();
		ItemStack i = e.getItem();
		if (i != null) {
			for (SuperItem customItem: SuperItems.items) {
				if (customItem.CheckItem(i)) {
					if (action == Action.LEFT_CLICK_AIR) {
						customItem.LeftClickAir(e);
					} else if (action == Action.RIGHT_CLICK_AIR) {
						customItem.RightClickAir(e);
					} else if (action == Action.LEFT_CLICK_BLOCK) {
						customItem.LeftClickBlock(e);
					} else if (action == Action.RIGHT_CLICK_BLOCK) {
						customItem.RightClickBlock(e);
					}
				}
			}
		}
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		ItemStack i = event.getPlayer().getInventory().getItemInMainHand();
		if (i != null) {
			for (SuperItem customItem: SuperItems.items) {
				if (customItem.CheckItem(i)) {
					customItem.BreakBlock(event);
				}
			}
		}
	}
	@EventHandler
	public void GrappleHandle(PlayerFishEvent event) {
		State fishState = event.getState();
		if (fishState == State.BITE || fishState == State.BITE)
			return;
		FishHook hook = event.getHook();
		Player player = event.getPlayer();
		for (SuperItem customItem: SuperItems.items) {
			if (customItem.CheckItem(player.getInventory().getItemInMainHand()) || customItem.CheckItem(player.getInventory().getItemInOffHand())) {
				Location hookLocation = hook.getLocation();
				Location playerLocation = player.getLocation();
				player.setVelocity(hookLocation.toVector().subtract(playerLocation.toVector()));
			}
		}
	}
	@EventHandler
	public void EnderBow(EntityShootBowEvent event) {
		for (SuperItem customItem:SuperItems.items){
			if (customItem.CheckItem(event.getBow())) {
				if (customItem instanceof EnderBow) {
					EnderBow item = (EnderBow) customItem;
					if (event.getEntity() instanceof Player) {
						item.EnderBow(event);
					}
				}
			}
		}
	}
}
