package me.michaelkrauty.Rank;

import me.michaelkrauty.Rank.Format;

import java.util.ArrayList;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Rank extends JavaPlugin{
	
	Logger log = Logger.getLogger("MC");
	
	public static Economy economy = null;
	
	private boolean setupEconomy(){
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null){
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}
	
	
	public void onEnable(){
		setupEconomy();
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("rank")){
			
			if(args[0].equalsIgnoreCase("help")){
				if(args.length == 1){
					sender.sendMessage(ChatColor.GREEN + "Rank commands:");
					sender.sendMessage(ChatColor.GREEN + "/rank help: Shows this dialogue");
					sender.sendMessage(ChatColor.GREEN + "/rank buy: Buy ranks");
					sender.sendMessage(ChatColor.GREEN + "/rank list: List all ranks");
					return true;
				}else{
					sender.sendMessage(ChatColor.GREEN + "Usage: /rank help");
					return true;
				}
			}
			
			
			
			if(args.length == 0){
				sender.sendMessage(syntaxError(sender.getName()));
				return true;
			}
			
			
			
			if(args[0].equalsIgnoreCase("buy")){
				ArrayList<String> ranks = getRanks();
				if(ranks.contains(args[0])){
					if(true){
						//TODO: buy
					}
				}
			}
			

			if(args[0].equalsIgnoreCase("list")){
				ArrayList<String> ranks = getRanks();
				for(int i = 0; i < ranks.size(); i++){
					getServer().broadcastMessage(i + " " + ranks.get(i));
				}
				return true;
			}
			
			
			
			
			sender.sendMessage(syntaxError(sender.getName()));
			return true;
		}
		return true;
	}
	
	public String asdf(){
		return ChatColor.RED + "Incorrect Usage!";
	}
	
	public String syntaxError(String str){
		return Format.format(getConfig().getString("unknown_command").replace("<player>", str));
	}
	
	public ArrayList<String> getRanks(){
		ArrayList<String> ranks = new ArrayList<String>(getConfig().getConfigurationSection("ranks").getKeys(true));
		for(int i = 0; i < ranks.size(); i++){
			if(ranks.get(i).contains(".name")){
				ranks.remove(i);
			}
		}
		return ranks;
	}
}