package me.michaelkrauty.Rank.commands;

import me.michaelkrauty.Rank.*;

import org.bukkit.entity.Player;

public class Buy extends Main {

	public Buy(Player player, String[] args) {
		RankFile rankFile = new RankFile();
		if (rankFile.getRanks().contains(args[1])) {
			if (Main.economy.getBalance(player.getName()) >= rankFile
					.getPrice(rankFile.getId(args[1]))) {
				for (int i = 0; i < rankFile.getCommands(args[1]).size(); i++) {
					Main.main.getServer().dispatchCommand(
							Main.main.getServer().getConsoleSender(),
							rankFile.getCommands(args[1]).get(i));
				}
			} else {
				player.sendMessage("You don't have enough money to buy the rank "
						+ rankFile.getName(rankFile.getId(args[1])));
				return;
			}
		} else {
			player.sendMessage("The rank \"" + args[1] + "\" doesn't exist!");
			return;
		}
	}
}
