package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;

import static com.github.donotspampls.bolbbot.Constants.*;

public class CrossUnbanCommand implements CommandExecutor {

    @Command(aliases = {",unban"}, usage = ",unban <user>", description = "Unbans a user from all Bolb Chairs game servers.")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) {
        if (author.canBanUsersFromServer()) {
            if (!message.getMentionedUsers().isEmpty()) {
                User user = message.getMentionedUsers().get(0);
                unbanUser(api, user);
                api.getTextChannelById(GAME_LOGS).ifPresent(channel -> channel.sendMessage("\uD83D\uDE4F Cross-unbanned **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` from the **Bolb Chairs** game servers."));
                message.addReaction("\uD83D\uDC4D");
            } else message.delete();
        } else message.delete();
    }

    private void unbanUser(DiscordApi api, User user) {
        api.getServerById(BOLB_CHAIRS_1).ifPresent(server -> server.unbanUser(user));
        api.getServerById(BOLB_CHAIRS_2).ifPresent(server -> server.unbanUser(user));
        api.getServerById(BOLB_CHAIRS_3).ifPresent(server -> server.unbanUser(user));
        api.getServerById(BOLB_CHAIRS_4).ifPresent(server -> server.unbanUser(user));
        api.getServerById(BOLB_CHAIRS_5).ifPresent(server -> server.unbanUser(user));
        api.getServerById(BOLB_CHAIRS_6).ifPresent(server -> server.banUser(user));
    }

}
