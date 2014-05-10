package me.michaelkrauty.Rank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.file.YamlConfiguration;

public class RankFile {

	File ranksFile;
	YamlConfiguration ranks = new YamlConfiguration();

	public void load() {
		try {
			ranksFile = new File(Main.main.getDataFolder() + "/" + "ranks.yml");
			if (!ranksFile.exists()) {
				ranksFile.createNewFile();
			}
			ranks.load(ranksFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getRanks() {
		ArrayList<String> rankList = new ArrayList<String>();
		try {
			load();
			Set<String> keys = ranks.getKeys(true);
			for (int i = 0; i < keys.size(); i++) {
				if (ranks.getString(i + ".name") != null) {
					rankList.add(ranks.getString(i + ".name"));
				}
			}
			return rankList;
		} catch (Exception e) {
			return null;
		}
	}

	public String getRankName(int id) {
		return ranks.getString(id + ".name");
	}

	public int getRankID(String name) {
		int returnInt = 0;
		try {
			load();
			Set<String> keys = ranks.getKeys(true);
			for (int i = 0; i < keys.size(); i++) {
				if (ranks.getString(i + ".name") != null) {
					if(ranks.getString(i + ".name").equalsIgnoreCase(name)) {
						returnInt = i;
					}
				}
			}
		} catch (Exception ignored) {
		}
		return returnInt;
	}

	public int getPrice(String name) {
		return ranks.getInt(getRankID(name) + ".price");
	}

	public ArrayList<String> getCommands(String name) {
		ArrayList<String> cmds = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<String> cmdlist = (List<String>) ranks.getList(getRankID(name)
				+ ".commands");
		for (int i = 0; i < cmdlist.size(); i++) {
			cmds.add((String) cmdlist.get(i));
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
