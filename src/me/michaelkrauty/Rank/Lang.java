package me.michaelkrauty.Rank;

public class Lang extends Main{
	
	public static String syntaxError(){
		return Format.format(main.getConfig().getString("unknown_command"));
	}
	public static String rankNotFound(){
		return Format.format(main.getConfig().getString("rank_not_found"));
	}
	public static String notEnoughMoney(){
		return Format.format(main.getConfig().getString("not_enough_money"));
	}
}
