package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.Main;
import me.michaelkrauty.Rank.RankFile;

import org.bukkit.entity.Player;

public class Test {

	public Test(Player player, String[] args) {
		RankFile rankFile = new RankFile();

		ArrayList<String> commands = rankFile.getCommands("example3");
		for (int i = 0; i < commands.size(); i++) {
			Main.main.getServer().broadcastMessage(commands.get(i));
		}

	}

}
