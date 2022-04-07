package ern.dev.vhutils.commands;

import ern.dev.vhutils.VHUtils;
import ern.dev.vhutils.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VHUtilsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("vhutils")) {
            if (args.length != 1) {

                return false;
            }
            if (args[0].equalsIgnoreCase("reload") && hasPerm(sender, "vhutils.reload")) {
                sender.sendMessage(VHUtils.config.tl("reload"));
                VHUtils.config.reload();

            }
        }

        return true;
    }

    private boolean hasPerm(CommandSender u, String permission){
        if (u instanceof Player) {
            if (u.hasPermission(permission) || u.isOp())
                return true;
            u.sendMessage(VHUtils.config.tl("no-permission"));
            return false;
        }
        return true;
    }
}
