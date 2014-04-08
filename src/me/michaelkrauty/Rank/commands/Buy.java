package me.michaelkrauty.Rank.commands;

import java.util.ArrayList;

import me.michaelkrauty.Rank.Rank;

import org.bukkit.entity.Player;

public class Buy extends Rank{

	public static void buy(Player player, String[] args){
		
		ArrayList<String> ranks = rank.getRanks();
		if(ranks.contains(args[0])){
			if(true){
				//TODO: buy
			}
		}
		
	}

}
