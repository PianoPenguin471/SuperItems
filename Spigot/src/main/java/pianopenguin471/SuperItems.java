package pianopenguin471;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pianopenguin471.commands.SuperItemCommand;
import pianopenguin471.gui.SuperItemGUI;
import pianopenguin471.items.SuperItem;
import pianopenguin471.items.*;
import pianopenguin471.items.SkyBlockItems.*;
import pianopenguin471.listeners.EventListener;

import java.util.ArrayList;
import java.util.List;

public final class SuperItems extends JavaPlugin {
	public static List<SuperItem> items = new ArrayList<>();
	@Override
	public void onEnable() {
		registerItems();
		SuperItemGUI menu = new SuperItemGUI();
		menu.register();
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new EventListener(), this);
		
		this.getCommand("superitems").setExecutor(new SuperItemCommand());
	}
	
	public void registerItems() {
		items.add(new LightningWand());
		items.add(new FireWand());
		items.add(new RandomMobWand());
		items.add(new RandomBlockWand());
		items.add(new SuperZapper());
		items.add(new EnderBow());
		
		//Skyblock Items
		items.add(new GrapplingHook());
		items.add(new AspectOfTheEnd());
		items.add(new SilentDeath());
	}
	
	@Override
	public void onDisable() {
		items.removeAll(items);
	}
}
