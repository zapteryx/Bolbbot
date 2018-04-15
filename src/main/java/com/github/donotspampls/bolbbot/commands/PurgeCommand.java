package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

public class PurgeCommand implements CommandExecutor {

    @Command(aliases = {",bc purge"}, usage = ",bc purge", description = "Clears the Bolb Chairs servers, ready for the next round.")
    public void onCommand(TextChannel channel, String[] args, Message message) {
        // code
    }

}
