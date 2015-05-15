package com.starnetmc.core.commands;

import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.Rank;

public class HelpCommand extends CommandBase<Chat> {

	public HelpCommand(Chat plugin) {
		super(plugin, Rank.DEFAULT, new String[] { "help" });
		// TODO Auto-generated constructor stub
	}

	public void execute(Player player, String[] args) {

		sendHelp(player);

	}

	public static void sendHelp(Player player) {
		try {
			switch (Manager.getRank(player.getUniqueId().toString())) {

			case DEFAULT:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case VIP:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case MVP:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case HELPER:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/punish (NOT IMPLEMENTED YET: "+F.AQUA+"Allows you to punish players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case MODERATOR:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/b: "+F.AQUA+"Allows you to broadcast a message to the whole server.");
				player.sendMessage(F.GOLD+"/tp: "+F.AQUA+"Allows you to teleport to players, or other players to other players.");
				player.sendMessage(F.GOLD+"/punish (NOT IMPLEMENTED YET: "+F.AQUA+"Allows you to punish players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case ADMIN:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/tpall: "+F.AQUA+"Allows you to teleport all online players to you.");
				player.sendMessage(F.GOLD+"/rank: "+F.AQUA+"Allows you to change a player's rank.");
				player.sendMessage(F.GOLD+"/t: "+F.AQUA+"Opens the time management menu.");
				player.sendMessage(F.GOLD+"/gm: "+F.AQUA+"Opens the gamemode management menu.");
				player.sendMessage(F.GOLD+"/setspawn: "+F.AQUA+"Allows you to set the server spawn point.");
				player.sendMessage(F.GOLD+"/b: "+F.AQUA+"Allows you to broadcast a message to the whole server.");
				player.sendMessage(F.GOLD+"/tp: "+F.AQUA+"Allows you to teleport to players, or other players to other players.");
				player.sendMessage(F.GOLD+"/punish (NOT IMPLEMENTED YET: "+F.AQUA+"Allows you to punish players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case YOUTUBE:
				break;
			case BUILDER:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/tpall: "+F.AQUA+"Allows you to teleport all online players to you.");
				player.sendMessage(F.GOLD+"/rank: "+F.AQUA+"Allows you to change a player's rank.");
				player.sendMessage(F.GOLD+"/t: "+F.AQUA+"Opens the time management menu.");
				player.sendMessage(F.GOLD+"/gm: "+F.AQUA+"Opens the gamemode management menu.");
				player.sendMessage(F.GOLD+"/setspawn: "+F.AQUA+"Allows you to set the server spawn point.");
				player.sendMessage(F.GOLD+"/b: "+F.AQUA+"Allows you to broadcast a message to the whole server.");
				player.sendMessage(F.GOLD+"/tp: "+F.AQUA+"Allows you to teleport to players, or other players to other players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case DEVELOPER:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/enable: "+F.AQUA+"Allows you to enable a disabled module.");
				player.sendMessage(F.GOLD+"/disable: "+F.AQUA+"Allows you to disable a module.");
				player.sendMessage(F.GOLD+"/npc: "+F.AQUA+"Allows you to create NPC's."+F.RED+" USE WITH CAUTION.");
				player.sendMessage(F.GOLD+"/chat <clear> <-n|-s|-a>: "+F.AQUA+"Allows you to clear chat.");
				player.sendMessage(F.GOLD+"/afk: "+F.AQUA+"Allows you to toggle the \"Away From Keyboard\" status.");
				player.sendMessage(F.GOLD+"/tpall: "+F.AQUA+"Allows you to teleport all online players to you.");
				player.sendMessage(F.GOLD+"/rank: "+F.AQUA+"Allows you to change a player's rank.");
				player.sendMessage(F.GOLD+"/t: "+F.AQUA+"Opens the time management menu.");
				player.sendMessage(F.GOLD+"/gm: "+F.AQUA+"Opens the gamemode management menu.");
				player.sendMessage(F.GOLD+"/setspawn: "+F.AQUA+"Allows you to set the server spawn point.");
				player.sendMessage(F.GOLD+"/b: "+F.AQUA+"Allows you to broadcast a message to the whole server.");
				player.sendMessage(F.GOLD+"/tp: "+F.AQUA+"Allows you to teleport to players, or other players to other players.");
				player.sendMessage(F.GOLD+"/punish (NOT IMPLEMENTED YET: "+F.AQUA+"Allows you to punish players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;
			case OWNER:
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-Your Commands-=-=-=-=-=-=-=-=-=-=-=");
				player.sendMessage(F.GOLD+"/help: "+F.AQUA+"Shows this message");
				player.sendMessage(F.GOLD+"/enable: "+F.AQUA+"Allows you to enable a disabled module.");
				player.sendMessage(F.GOLD+"/disable: "+F.AQUA+"Allows you to disable a module.");
				player.sendMessage(F.GOLD+"/npc: "+F.AQUA+"Allows you to create NPC's."+F.RED+" USE WITH CAUTION.");
				player.sendMessage(F.GOLD+"/chat <clear> <-n|-s|-a>: "+F.AQUA+"Allows you to clear chat.");
				player.sendMessage(F.GOLD+"/afk: "+F.AQUA+"Allows you to toggle the \"Away From Keyboard\" status.");
				player.sendMessage(F.GOLD+"/tpall: "+F.AQUA+"Allows you to teleport all online players to you.");
				player.sendMessage(F.GOLD+"/rank: "+F.AQUA+"Allows you to change a player's rank.");
				player.sendMessage(F.GOLD+"/t: "+F.AQUA+"Opens the time management menu.");
				player.sendMessage(F.GOLD+"/gm: "+F.AQUA+"Opens the gamemode management menu.");
				player.sendMessage(F.GOLD+"/setspawn: "+F.AQUA+"Allows you to set the server spawn point.");
				player.sendMessage(F.GOLD+"/b: "+F.AQUA+"Allows you to broadcast a message to the whole server.");
				player.sendMessage(F.GOLD+"/tp: "+F.AQUA+"Allows you to teleport to players, or other players to other players.");
				player.sendMessage(F.GOLD+"/punish (NOT IMPLEMENTED YET: "+F.AQUA+"Allows you to punish players.");
				player.sendMessage(F.GOLD+"/sc: "+F.AQUA+"Allows you to talk to all other online staff privately.");
				player.sendMessage(F.GOLD+"/spawn: "+F.AQUA+"Sends you to spawn.");
				player.sendMessage(F.GOLD+"/settings: "+F.AQUA+"Opens the settings menu.");
				player.sendMessage(F.GOLD+"/gadgets: "+F.AQUA+"Opens the gadgets menu.");
				player.sendMessage(F.GOLD+"/msg: "+F.AQUA+"Sends a private message to the specified player.");
				player.sendMessage(F.GOLD+"/r: "+F.AQUA+"A quick reply to players you have messaged recently.");
				player.sendMessage(F.GOLD+"/test: "+F.RED+"A test command."+F.AQUA+" Allows you to test any new things Spark has added!");
				player.sendMessage(F.strikeGreen+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				break;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
