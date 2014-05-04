package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.Main;
import me.michaelkrauty.Rank.RankFile;

import org.bukkit.entity.Player;

public class List {

	public List(Player player, String[] args) {
		RankFile rankFile = new RankFile();

		ArrayList<Integer> ranks = rankFile.getRanks();
		for (int i = 0; i < ranks.size(); i++) {
			Main.main.getServer().broadcastMessage(
					rankFile.getName(ranks.get(i)));
		}
		return;
	}
}
