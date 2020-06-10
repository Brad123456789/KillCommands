package com.BradTheGamer.KillCommands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.entity.PlayerDeathEvent;
public class Main extends JavaPlugin implements Listener {
	// Variables
	String config_command  = "";
	String config_message  = "";
	String config_command2  = "";
	boolean config_enabled = false;
	String prefix = ChatColor.RED + "VexKills " + ChatColor.DARK_RED + "»" + ChatColor.GREEN;
	String command_temp = "";
	String command_temp2 = "";
	@Override
	public void onEnable()	{
		this.saveDefaultConfig();
		config_command = this.getConfig().getString("Command");
		config_command2 = this.getConfig().getString("Command2");
		config_enabled = this.getConfig().getBoolean("Enabled");
		config_message = this.getConfig().getString("Message");
		getServer().getPluginManager().registerEvents(new MyListener(), this);	
    }
    public class MyListener implements Listener {
    	 @EventHandler
    	 public void onKill(PlayerDeathEvent e) {
         if (config_enabled == true){
    	 String killed = e.getEntity().getName();
    	 String killer = e.getEntity().getKiller().getName();
         	command_temp = config_command;
         	command_temp2 = config_command2;
         	command_temp = command_temp.replace("%Prefix%",  prefix);
         	command_temp = command_temp.replace("%Command%", config_command);
         	command_temp = command_temp.replace("%Killer%", killer);
         	command_temp = command_temp.replace("%PlayerKilled%", killed);
         	command_temp2 = command_temp2.replace("%Prefix%",  prefix);
         	command_temp2 = command_temp2.replace("%Command%", config_command);
         	command_temp2 = command_temp2.replace("%Killer%", killer);
         	command_temp2 = command_temp2.replace("%PlayerKilled%", killed);
         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command_temp);
         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command_temp2);
         	e.getEntity().getKiller().sendMessage(prefix + " You recieved rewards for killing §4" + killed);        
         	}   	    
         	}      
    	 }  	 
    }

    