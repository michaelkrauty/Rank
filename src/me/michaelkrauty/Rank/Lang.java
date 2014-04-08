package me.michaelkrauty.Rank;

public class Lang extends Rank{
	
	public static String syntaxError(String str){
		return Format.format(rank.getConfig().getString("unknown_command").replace("<player>", str));
	}
}
