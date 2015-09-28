package com.starnetmc.core.commands;

import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.serversorter.GameType;
import com.starnetmc.core.serversorter.ServerSorter;
import com.starnetmc.core.util.Rank;

public class Test extends CommandBase<Chat>{

	public Test(Chat plugin) {
		super(plugin, Rank.DEFAULT, new String[] { "test" });
	}
	
	public void execute(Player player, String[] args) {
		ServerSorter.getGameGUI(GameType.DRAGONSWORD).open(player);
		return;
	}
	
}