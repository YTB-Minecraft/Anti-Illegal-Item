package org.ytb.anarchy.anti_illegal;

import org.bukkit.plugin.java.JavaPlugin;
import org.ytb.anarchy.anti_illegal.anti_32k.Main32k;

public class Main extends JavaPlugin{
	public void onEnable() {
		System.out.println("\n\nYTB Anarchy ���D�k���~�w�g���\���J\n\n�������YTB�ζ��s�@!�ФŪ����ק�/��s�ɮ�!");
		getServer().getPluginManager().registerEvents(new Main32k(this), this);
		getServer().getPluginCommand("kit").setExecutor(new givekit());
	}
}
