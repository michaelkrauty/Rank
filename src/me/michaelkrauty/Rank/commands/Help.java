package me.michaelkrauty.Rank.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {

	public static void help(Player player, String[] args) {
		if(args.length == 1){
			player.sendMessage(ChatColor.GREEN + "Rank commands:");
			player.sendMessage(ChatColor.GREEN + "/rank help: Shows this dialogue");
			player.sendMessage(ChatColor.GREEN + "/rank buy: Buy ranks");
			player.sendMessage(ChatColor.GREEN + "/rank list: List all ranks");
			return;
		}else{
			player.sendMessage(ChatColor.GREEN + "Usage: /rank help");
			return;
		}
	}

}
