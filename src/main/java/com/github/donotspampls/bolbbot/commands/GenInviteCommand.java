package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

public class GenInviteCommand implements CommandExecutor {

    @Command(aliases = {",bc gen"}, usage = ",bc gen <server> [uses]", description = "Generates an invite for a chosen Bolb Chairs server.")
    public void onCommand(TextChannel channel, String[] args, Message message) {
        // code
    }

}
