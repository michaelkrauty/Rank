package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.Main;

import org.bukkit.entity.Player;

public class List extends Main {

	public List(Player player, String[] args) {

		ArrayList<String> ranks = rankFile.getRanks();
		for (int i = 0; i < ranks.size(); i++) {
			Main.main.getServer().broadcastMessage(i + " " + ranks.get(i));
		}

	}

}
