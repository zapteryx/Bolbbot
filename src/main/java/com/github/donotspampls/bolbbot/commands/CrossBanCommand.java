package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

public class CrossBanCommand implements CommandExecutor {

    @Command(aliases = {",ban"}, usage = ",ban <user>", description = "Bans a user from all Bolb Chairs game servers.")
    public void onCommand(TextChannel channel, String[] args, Message message) {
        // code
    }

}
