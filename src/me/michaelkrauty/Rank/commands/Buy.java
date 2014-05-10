package me.michaelkrauty.Rank.commands;

import me.michaelkrauty.Rank.Main;
import me.michaelkrauty.Rank.RankFile;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Buy {

	private final Main main = Main.main;
	private final RankFile rankFile = Main.rankFile;
	private final Economy economy = Main.economy;

	public Buy(Player player, String[] args) {
		if (args.length == 2) {
			boolean contains = false;
			for (int i = 0; i < rankFile.getRanks().size(); i++) {
				if (rankFile.getRanks().get(i).equalsIgnoreCase(args[1])) {
					contains = true;
				}
			}
			if (contains) {
				if (economy.getBalance(player.getName()) >= rankFile
						.getPrice(args[1])) {
					for (int i = 0; i < rankFile.getCommands(args[1]).size(); i++) {
						main.getServer().dispatchCommand(
								main.getServer().getConsoleSender(),
								rankFile.getCommands(args[1]).get(i));
					}
					economy.withdrawPlayer(player.getName(),
							rankFile.getPrice(args[1]));

				} else {
					player.sendMessage(ChatColor.GRAY
							+ "You don't have enough money to buy that rank! ("
							+ economy.getBalance(player.getName()) + "/"
							+ rankFile.getPrice(args[1]));
				}
			} else {
				player.sendMessage(ChatColor.GRAY + "The rank " + args[1]
						+ " doesn't exist!");
			}
		} else {
			player.sendMessage(ChatColor.GRAY + "Usage: /rank buy <rank>");
		}
	}
}
