package me.michaelkrauty.Rank.commands;

import me.michaelkrauty.Rank.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Buy {

	public Buy(Player player, String[] args) {
		RankFile rankFile = new RankFile();
		if (rankFile.getRanks().contains(rankFile.getId(args[1]))) {
			if (Main.economy.getBalance(player.getName()) >= rankFile
					.getPrice(rankFile.getId(args[1]))) {
				Main.economy.withdrawPlayer(player.getName(), rankFile.getPrice(rankFile.getId(args[1])));
				for (int i = 0; i < rankFile.getCommands(args[1]).size(); i++) {
					Main.main.getServer().dispatchCommand(
							Main.main.getServer().getConsoleSender(),
							rankFile.getCommands(args[1]).get(i));
				}
				player.sendMessage(ChatColor.GRAY
						+ "Successfully bought the rank "
						+ rankFile.getName(rankFile.getId(args[1])) + " for "
						+ rankFile.getPrice(rankFile.getId(args[1])));
				return;
			} else {
				player.sendMessage(ChatColor.GRAY + "You don't have enough money to buy the rank "
						+ rankFile.getName(rankFile.getId(args[1])));
				return;
			}
		} else {
			player.sendMessage(ChatColor.GRAY + "The rank \"" + args[1] + "\" doesn't exist!");
			return;
		}
	}
}
