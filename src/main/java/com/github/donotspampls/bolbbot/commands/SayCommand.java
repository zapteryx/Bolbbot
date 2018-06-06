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

            api.getServerById(BOLB_CHAIRS_1).getChannelByName("spam", 0).ifPresent(channel -> channel.sendMessage(msg));
            api.getServerById(BOLB_CHAIRS_2).getChannelByName("spam", 0).ifPresent(channel -> channel.sendMessage(msg));
            api.getServerById(BOLB_CHAIRS_3).getChannelByName("colon-bolbchair-colon", 0).ifPresent(channel -> channel.sendMessage(msg));
            api.getServerById(BOLB_CHAIRS_4).getChannelByName("do-you-like-nitro", 0).ifPresent(channel -> channel.sendMessage(msg));
            api.getServerById(BOLB_CHAIRS_5).getChannelByName("this-is-not-stressful", 0).ifPresent(channel -> channel.sendMessage(msg));
            api.getServerById(BOLB_CHAIRS_6).getChannelByName("no-free-nitro-here", 0).ifPresent(channel -> channel.sendMessage(msg));
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
