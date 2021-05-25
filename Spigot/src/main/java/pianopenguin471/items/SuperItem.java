package pianopenguin471.items;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class SuperItem {
	public String itemName;
	public List<String> itemLore;
	public Material itemMaterial;
	public void telekinisisDestroy(@NotNull Block block, @NotNull Player player) {
		for (ItemStack itemStack : block.getDrops(player.getInventory().getItemInMainHand())) {
			player.getInventory().addItem(itemStack);
		}
		block.setType(Material.AIR);
	}
	public boolean CheckItem(@NotNull ItemStack otherItem) {
		ItemMeta meta = otherItem.getItemMeta();
		Material material = otherItem.getType();
		if (!meta.hasDisplayName())
			return false;
		if (!meta.hasLore())
			return false;
		String name = meta.getDisplayName();
		List<String> lore = meta.getLore();
		return (name.equals(this.itemName) && lore.equals(this.itemLore) && material.equals(this.itemMaterial));
	}
	public void RightClickBlock(PlayerInteractEvent event) {}
	public ItemStack getItem() {
		ItemStack wand = new ItemStack(this.itemMaterial, 1);
		wand.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
		ItemMeta meta = wand.getItemMeta();
		meta.setDisplayName(this.itemName);
		meta.setLore(this.itemLore);
		wand.setItemMeta(meta);
		return wand;
	}
	
	public void addAbility(String abilityName, String abilityDescription) {
		this.itemLore.add(ChatColor.GOLD + "Item Ability: " + abilityName + ChatColor.RESET + "" + ChatColor.WHITE + " - " + abilityDescription);
	}
	
	public Location getLocationInFrontOfPlayer (Entity entity, int distance) {
		Location location = entity.getLocation().add(0, entity.getHeight(), 0);
		Vector direction = location.getDirection();
		Location location1;
		location1 = location.add(direction.multiply(distance));
		return location1;
	}
	
	public void RightClickAir(PlayerInteractEvent event) {}
	public void LeftClickBlock(PlayerInteractEvent event) {}
	public void LeftClickAir(PlayerInteractEvent event) {}
	public void BreakBlock(BlockBreakEvent event) {}
}
