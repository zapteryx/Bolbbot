package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import static com.github.donotspampls.bolbbot.Constants.*;

public class SayCommand implements CommandExecutor {

    @Command(aliases = {",say"}, usage = ",say <message>", description = "Broadcasts a message to all Bolb Chairs game servers!")
    public void onCommand(DiscordApi api, String[] args, Message message, MessageAuthor author) {
        if (author.canManageMessagesInTextChannel()) {
            String msg = String.join(" ", args);

            api.getTextChannelById(BC1_INFO).ifPresent(channel -> channel.sendMessage(msg));
            api.getTextChannelById(BC2_INFO).ifPresent(channel -> channel.sendMessage(msg));
            api.getTextChannelById(BC3_GENERAL).ifPresent(channel -> channel.sendMessage(msg));
            api.getTextChannelById(BC4_GENERAL).ifPresent(channel -> channel.sendMessage(msg));
            api.getTextChannelById(BC5_GENERAL).ifPresent(channel -> channel.sendMessage(msg));
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
