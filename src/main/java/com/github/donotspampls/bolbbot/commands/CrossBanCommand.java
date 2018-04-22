package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import static com.github.donotspampls.bolbbot.Constants.*;

public class CrossBanCommand implements CommandExecutor {

    @Command(aliases = {",ban"}, usage = ",ban <user>", description = "Bans a user from all Bolb Chairs game servers.")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) {
        if (author.canBanUsersFromServer()) {
            if (!message.getMentionedUsers().isEmpty()) {
                User user = message.getMentionedUsers().get(0);

                api.getServerById(BOLB_CHAIRS_1).ifPresent(server -> server.banUser(user));
                api.getServerById(BOLB_CHAIRS_2).ifPresent(server -> server.banUser(user));
                api.getServerById(BOLB_CHAIRS_3).ifPresent(server -> server.banUser(user));
                api.getServerById(BOLB_CHAIRS_4).ifPresent(server -> server.banUser(user));
                api.getServerById(BOLB_CHAIRS_5).ifPresent(server -> server.banUser(user));

                message.addReaction("\uD83D\uDC4D");
                api.getTextChannelById(GAME_LOGS).ifPresent(channel -> channel.sendMessage("\uD83D\uDD28 Cross-banned **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` from the **Bolb Chairs** game servers."));
            } else {
                message.addReaction("⚠");
            }
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }
}
