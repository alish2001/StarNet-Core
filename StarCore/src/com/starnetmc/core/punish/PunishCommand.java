package com.starnetmc.core.punish;

import org.bukkit.entity.Player;

import com.starnetmc.core.accounts.AccountManager;
import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.database.Databaser;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Rank;
import com.starnetmc.core.util.StarMap;
import com.starnetmc.core.util.UString;

public class PunishCommand extends CommandBase<Punish> {

	public static StarMap<String, Punishment> punish = new StarMap<String, Punishment>();

	public PunishCommand(Punish plugin) {
		super(plugin, Rank.HELPER, new String[] { "punish", "p" });
	}

	public void execute(Player player, String[] args) {

		if(args.length < 2) {
			player.sendMessage(F.error("Commands", "Not enough arguments!"));
			return;
		}
		
		try {
			if (!Databaser.usernameHasAccount(args[0])){
				player.sendMessage(F.error("Punishments", "This player has never played before!"));
				return;
			}
			
			punish.put(player.getUniqueId().toString(), new Punishment(Databaser.getUUID(args[0]), player.getUniqueId().toString()));
			String reason = UString.forgeArgMessage(args, 1);
			punish.get(player.getUniqueId().toString()).setReason(reason);
			
			if (AccountManager.getAccount(player).getRank() == Rank.HELPER){
				PunishGUI.showHelperMenu(player, punish.get(player.getUniqueId().toString()));
				return;
				
			} else {
				
				PunishGUI.showOtherMenu(player, punish.get(player.getUniqueId().toString()));
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}