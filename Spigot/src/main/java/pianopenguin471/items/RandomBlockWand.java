package pianopenguin471.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBlockWand extends SuperItem {
	public static List<Material> blocks = new ArrayList<>();
	public RandomBlockWand() {
		populateBlocks();
		this.itemName = "Random Block Wand";
		this.itemLore = Arrays.asList("Powered by Redstone","By Pianopenguin471");
		this.itemMaterial = Material.STICK;
	}
	private void populateBlocks() {
		for (Material blockMaterial : Material.values()) {
			if (blockMaterial.isBlock()) {
				blocks.add(blockMaterial);
			}
		}
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
		event.getClickedBlock().setType(blocks.get(new Random().nextInt(blocks.size())));
	}
}
