package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageSet;

import static com.github.donotspampls.bolbbot.Constants.*;

public class PurgeCommand implements CommandExecutor {

    @Command(aliases = {",purge"}, usage = ",purge", description = "Clears the Bolb Chairs servers, ready for the next round.")
    public void onCommand(DiscordApi api, String[] args, Message message) {
        // Delete all messages
        api.getTextChannelById(BC1_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
        api.getTextChannelById(BC2_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
        api.getTextChannelById(BC3_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
        api.getTextChannelById(BC4_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
        api.getTextChannelById(BC5_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
        api.getTextChannelById(BC6_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));

        // Kick all members without a role
        // code here
    }

}
