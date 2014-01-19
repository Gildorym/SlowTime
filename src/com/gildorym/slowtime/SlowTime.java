package com.gildorym.slowtime;

import org.bukkit.plugin.java.JavaPlugin;

public class SlowTime extends JavaPlugin {
	
	public void onEnable() {
		 
		//Every 15 minutes, the server will synchronize the time of day with the calendar
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		 
		@Override
		public void run() {
		//Gets IRL time, in milliseconds, after most recent 1/5 day interval in UTC + 1
			long irlTimeMillis = (System.currentTimeMillis() + 3600000L) % 17280000L;
		 
		//Calculates desired time of day in Minecraft based on IRL time, in ticks.
			double dayfraction = ((double) irlTimeMillis) / ((double) 17280000L);
			long syncedTimeOfDay = (((long) (dayfraction * 24000D)) + 18000L) % 24000L;
		 
		//Synchronizes server time of day with time of day based on calendar
			SlowTime.this.getServer().getWorlds().get(0).setTime(syncedTimeOfDay);
			//getLogger().info(ChatColor.WHITE + "Server time synchronized to " + syncedTimeOfDay);
			}
		 
		}, 100L, 100L);
	}

}
