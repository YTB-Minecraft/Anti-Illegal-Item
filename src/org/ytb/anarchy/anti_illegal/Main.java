package org.ytb.anarchy.anti_illegal;

import org.bukkit.plugin.java.JavaPlugin;
import org.ytb.anarchy.anti_illegal.anti_32k.Main32k;

public class Main extends JavaPlugin{
	public void onEnable() {
		System.out.println("\n\nYTB Anarchy 防非法物品已經成功載入\n\n本插件由YTB團隊製作!請勿直接修改/更新檔案!");
		getServer().getPluginManager().registerEvents(new Main32k(this), this);
		getServer().getPluginCommand("kit").setExecutor(new givekit());
	}
}
