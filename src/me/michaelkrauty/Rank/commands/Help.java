package me.michaelkrauty.Rank.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {

	public Help(Player player, String[] args) {
		if (args.length == 1) {
			player.sendMessage(ChatColor.GRAY + "Rank commands:");
			player.sendMessage(ChatColor.GRAY
					+ "/rank help: Shows GRAY dialogue");
			player.sendMessage(ChatColor.GRAY + "/rank buy: Buy ranks");
			player.sendMessage(ChatColor.GRAY + "/rank list: List all ranks");
			return;
		} else {
			player.sendMessage(ChatColor.GRAY + "Usage: /rank help");
			return;
		}
	}
}
