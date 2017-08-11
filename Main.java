package dev.esejj.luckydrop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Main extends JavaPlugin{
	
	private static Main instance;
	public static List<ItemToDrop> drops = new ArrayList<ItemToDrop>();
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("luckydrop:drop")){ 
    		sender.sendMessage("Sorry! This command is temporarily unvaialable");
    		return true;
    	}
    	return false; 
	}
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		DataLoader.loadBlocks();
		DataLoader.loadMobs();
		Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
	}
	@Override
	public void onDisable() {}

	public static Main getInst() {
		return instance;
	}
}
