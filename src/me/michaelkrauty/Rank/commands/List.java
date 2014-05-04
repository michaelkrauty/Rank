package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.RankFile;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class List {

	public List(Player player, String[] args) {
		RankFile rankFile = new RankFile();

		ArrayList<Integer> ranks = rankFile.getRanks();
		String out = "";
		for (int i = 0; i < ranks.size(); i++) {
			if (i == (ranks.size() - 1)) {
				out = out + rankFile.getName(ranks.get(i));
			} else {
				out = out + rankFile.getName(ranks.get(i)) + ", ";
			}
		}
		player.sendMessage(ChatColor.GRAY + "Ranks: " + out);
		return;
	}
}
