package me.michaelkrauty.Rank;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Rank extends JavaPlugin implements Listener{
	
    public static Economy economy = null;

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		setupEconomy();
	}
	
	int ironprice = 524288;
	int goldprice = 1048576;
	int diamondprice = 4194304;
	int obsidianprice = 8388608;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]){
		
		if(commandLabel.equalsIgnoreCase("rank")){
			
			if(args[0].equalsIgnoreCase("buy")){
				if(args[1].equalsIgnoreCase("iron")){
					if(economy.getBalance(sender.getName()) >= ironprice){
						economy.withdrawPlayer(sender.getName(), ironprice);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " group set iron");
						getServer().broadcastMessage(ChatColor.GREEN + "Congrats to " + sender.getName() + " for buying the rank Iron!");
						return true;
					}else{
						sender.sendMessage(ChatColor.GREEN + "You need at least $" + ironprice + " to buy this rank.");
						return true;
					}
				}
				if(args[1].equalsIgnoreCase("gold")){
					if(economy.getBalance(sender.getName()) >= goldprice){
						economy.withdrawPlayer(sender.getName(), goldprice);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " group set gold");
						getServer().broadcastMessage(ChatColor.GREEN + "Congrats to " + sender.getName() + " for buying the rank Gold!");
						return true;
					}else{
						sender.sendMessage(ChatColor.GREEN + "You need at least $" + goldprice + " to buy this rank.");
						return true;
					}
				}
				if(args[1].equalsIgnoreCase("diamond")){
					if(economy.getBalance(sender.getName()) >= diamondprice){
						economy.withdrawPlayer(sender.getName(), diamondprice);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " group set diamond");
						getServer().broadcastMessage(ChatColor.GREEN + "Congrats to " + sender.getName() + " for buying the rank Diamond!");
						return true;
					}else{
						sender.sendMessage(ChatColor.GREEN + "You need at least $" + diamondprice + " to buy this rank.");
						return true;
					}
				}
				if(args[1].equalsIgnoreCase("obsidian")){
					if(economy.getBalance(sender.getName()) >= obsidianprice){
						economy.withdrawPlayer(sender.getName(), obsidianprice);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " group set obsidian");
						getServer().broadcastMessage(ChatColor.GREEN + "Congrats to " + sender.getName() + " for buying the rank Obsidian!");
						return true;
					}else{
						sender.sendMessage(ChatColor.GREEN + "You need at least $" + obsidianprice + " to buy this rank.");
						return true;
					}
				}
				
				else{
					sender.sendMessage(ChatColor.GREEN + "Couldn't find that rank! Use /rank list for a list of available ranks.");
					return true;
				}
			}
			
			if(args[0].equalsIgnoreCase("info")){
				if(args[1].equalsIgnoreCase("iron")){
					sender.sendMessage(ChatColor.GREEN + "Cost: $" + ironprice + " (64 diamonds)");
					return true;
				}
				if(args[1].equalsIgnoreCase("gold")){
					sender.sendMessage(ChatColor.GREEN + "Cost: $" + goldprice + " (128 diamonds)");
					return true;
				}
				if(args[1].equalsIgnoreCase("diamond")){
					sender.sendMessage(ChatColor.GREEN + "Cost: $" + diamondprice + " (512 diamonds)");
					return true;
				}
				if(args[1].equalsIgnoreCase("obsidian")){
					sender.sendMessage(ChatColor.GREEN + "Cost: $" + obsidianprice + " (1024 diamonds)");
					return true;
				}
				
				else{
					sender.sendMessage("Couldn't find that rank! Use /rank list for a list of ranks.");
					return true;
				}
			}
			
			if(args[0].equalsIgnoreCase("list")){
				
				sender.sendMessage(ChatColor.GREEN + "Ranks on mc247:");
				sender.sendMessage(ChatColor.GREEN + "Iron, Gold, Diamond, Obsidian");
				sender.sendMessage(ChatColor.GREEN + "Use /rank info <rank> for more info on each rank.");
				
				return true;
			}
			
			if(args[0].equalsIgnoreCase("help")){
				sender.sendMessage(ChatColor.GREEN + "/rank info <rank>: Get info about a rank.");
				sender.sendMessage(ChatColor.GREEN + "/rank List: list all available ranks.");
				sender.sendMessage(ChatColor.GREEN + "/rank buy <rank>: Buy a rank");
				sender.sendMessage(ChatColor.GREEN + "/rank help: Show this dialogue");
				return true;
			}
			
			else{
				sender.sendMessage(ChatColor.GREEN + "Unknown command! Use /rank help for help.");
				return true;
			}
		}
		
		return true;
	}
	
	
}
