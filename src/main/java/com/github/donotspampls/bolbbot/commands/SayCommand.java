package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import java.util.concurrent.TimeUnit;

import static com.github.donotspampls.bolbbot.Constants.*;

public class SayCommand implements CommandExecutor {

    @Command(aliases = {",say"}, usage = ",say <message>", description = "Broadcasts a message to all Bolb Chairs game servers!")
    public void onCommand(DiscordApi api, String[] args, Message message, MessageAuthor author) throws InterruptedException {
        if (author.canManageMessagesInTextChannel()) {
            String msg = String.join(" ", args);
            broadcast(msg, api);
            message.addReaction("\uD83D\uDC4D");
            TimeUnit.SECONDS.sleep(3);
            message.delete();
        } else message.delete();
    }

    public static void broadcast(String msg, DiscordApi api) {
        api.getServerById(BOLB_CHAIRS_1).ifPresent(server -> server.getChannelsByName(BC1_INFO).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
        api.getServerById(BOLB_CHAIRS_2).ifPresent(server -> server.getChannelsByName(BC2_INFO).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
        api.getServerById(BOLB_CHAIRS_3).ifPresent(server -> server.getChannelsByName(BC3_CHANNEL).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
        api.getServerById(BOLB_CHAIRS_4).ifPresent(server -> server.getChannelsByName(BC4_CHANNEL).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
        api.getServerById(BOLB_CHAIRS_5).ifPresent(server -> server.getChannelsByName(BC5_CHANNEL).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
        api.getServerById(BOLB_CHAIRS_6).ifPresent(server -> server.getChannelsByName(BC6_CHANNEL).get(0).asServerTextChannel().ifPresent(channel -> channel.sendMessage(msg)));
    }

}
