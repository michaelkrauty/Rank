package me.michaelkrauty.Rank;

public class Lang extends Rank{
	
	public static String syntaxError(){
		return Format.format(rank.getConfig().getString("unknown_command"));
	}
	public static String rankNotFound(){
		return Format.format(rank.getConfig().getString("rank_not_found"));
	}
	public static String notEnoughMoney(){
		return Format.format(rank.getConfig().getString("not_enough_money"));
	}
}
