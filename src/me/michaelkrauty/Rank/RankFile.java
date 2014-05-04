package me.michaelkrauty.Rank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class RankFile {

	File ranksFile;
	YamlConfiguration ranks = new YamlConfiguration();

	public void load() {
		try {
			ranksFile = new File(Main.main.getDataFolder() + "/" + "ranks.yml");
			if (!ranksFile.exists()) {
				Main.main.log.info("Creating new ranks.yml in \""
						+ Main.main.getDataFolder() + "/" + "ranks.yml\"");
				ranksFile.createNewFile();
			}
			ranks.load(ranksFile);
		} catch (Exception e) {
			Main.main.log.info("Couldn't load ranks.yml!");
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getRanks() {
		ArrayList<Integer> rankList = new ArrayList<Integer>();
		try {
			load();
			Object[] keys = ranks.getKeys(true).toArray();
			for (int i = 0; i < keys.length; i++) {
				int rank = 0;
				boolean num = true;
				try {
					rank = Integer.parseInt(keys[i].toString());
				} catch (NumberFormatException e) {
					num = false;
				}
				if (num) {
					rankList.add(rank);
				}
			}
			return rankList;
		} catch (Exception e) {
			Main.main.log.info("ranks.yml is empty!");
			e.printStackTrace();
			return null;
		}
	}

	public String getName(int id) {
		return ranks.getString(getRanks().get(id) + ".name");
	}

	public int getId(String name) {
		int id = -1;
		for (int i = 0; i < getRanks().size(); i++) {
			if (getName(getRanks().get(i)).equalsIgnoreCase(name)) {
				id = i;
			}
		}
		return id;
	}

	public int getPrice(int id) {
		return ranks.getInt(getRanks().get(id) + ".price");
	}

	public int getPrice(String name) {
		return ranks.getInt(name + ".price");
	}

	public ArrayList<String> getCommands(String name) {
		ArrayList<String> cmds = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<String> commands = (List<String>) ranks.getList(getId(name)
				+ ".commands");
		for (int i = 0; i < commands.size(); i++) {
			cmds.add(commands.get(i));
		}
		return cmds;
	}

	@SuppressWarnings("unused")
	private void save() {
		try {
			ranks.save(ranksFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
