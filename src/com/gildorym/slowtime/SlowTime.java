package com.gildorym.slowtime;

import org.bukkit.plugin.java.JavaPlugin;

public class SlowTime extends JavaPlugin {
	
	public void onEnable() {
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				// -67L is equal to -72L + 72L * (5D/72D)
				// Regular Minecraft speed is 1 MC Day / 20 IRL min
				// This plugin sets time equal to 5/72 of Regular Minecraft Speed
				// Modified Minecraft speed becomes 5 MC Days / 1440 IRL min (1 IRL Day)
				SlowTime.this.getServer().getWorlds().get(0).setFullTime((long) (SlowTime.this.getServer().getWorlds().get(0).getFullTime() - 67L));
			}
			
		}, 72L, 72L);
	}

}
