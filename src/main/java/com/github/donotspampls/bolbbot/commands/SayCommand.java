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

            api.getServerById(BOLB_CHAIRS_1).ifPresent(server -> {
                server.getChannelsByName("info").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

            api.getServerById(BOLB_CHAIRS_2).ifPresent(server -> {
                server.getChannelsByName("info").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

            api.getServerById(BOLB_CHAIRS_3).ifPresent(server -> {
                server.getChannelsByName("colon-bolbchair-colon").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

            api.getServerById(BOLB_CHAIRS_4).ifPresent(server -> {
                server.getChannelsByName("do-you-like-nitro").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

            api.getServerById(BOLB_CHAIRS_5).ifPresent(server -> {
                server.getChannelsByName("this-is-not-stressful").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

            api.getServerById(BOLB_CHAIRS_6).ifPresent(server -> {
                server.getChannelsByName("no-free-nitro-here").get(0).asServerTextChannel().ifPresent(channel -> {
                    channel.sendMessage(msg);
                });
            });

        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
