package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.Rank;

import org.bukkit.entity.Player;

public class List extends Rank{

	public static void list(Player player, String[] args){
		
		ArrayList<String> ranks = rank.getRanks();
		for(int i = 0; i < ranks.size(); i++){
			rank.getServer().broadcastMessage(i + " " + ranks.get(i));
		}
		
	}

}
