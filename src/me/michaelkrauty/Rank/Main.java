package me.michaelkrauty.Rank;

import me.michaelkrauty.Rank.commands.*;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

// TODO: create scheduler to check player stats every x minutes & make changes accordingly
// TODO: add listeners for player/mob kill events

public class Main extends JavaPlugin {

	public static Main main;

	Logger log = Logger.getLogger("MC");

	public static Economy economy = null;

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer()
				.getServicesManager().getRegistration(
						net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}

	public void onEnable() {
		main = this;
		setupEconomy();
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("rank")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("Silly console, you're a console!");
				return false;
			}
			Player player = (Player) sender;

			if (args.length == 0) {
				player.sendMessage(ChatColor.GRAY
						+ "Incorrect usage! Use \"/rank help\" for help!");
				return true;
			}

			if (args[0].equalsIgnoreCase("help")) {
				new Help(player, args);
				return true;
			}

			if (args[0].equalsIgnoreCase("buy")) {
				new Buy(player, args);
				return true;
			}

			if (args[0].equalsIgnoreCase("list")) {
				new List(player, args);
				return true;
			}

			if (args[0].equalsIgnoreCase("test")) {
				new Test(player, args);
				return true;
			}

			player.sendMessage(ChatColor.GRAY
					+ "Unknown command! Use \"/rank help\" for help!");
			return true;
		}
		return true;
	}
}