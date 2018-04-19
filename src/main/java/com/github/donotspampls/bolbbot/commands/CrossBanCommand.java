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
            User user = message.getMentionedUsers().get(0);
            Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();

            bc1.banUser(user);
            bc2.banUser(user);
            bc3.banUser(user);
            bc4.banUser(user);
            bc5.banUser(user);

            message.addReaction("\uD83D\uDC4D");
            api.getTextChannelById(GAME_LOGS).ifPresent(channel -> channel.sendMessage("\uD83D\uDD28 Cross-banned **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` from the **Bolb Chairs** game servers."));
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }
}
