package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.util.Collection;

import static com.github.donotspampls.bolbbot.Constants.*;

public class PurgeCommand implements CommandExecutor {

    @Command(aliases = {",purge"}, usage = ",purge", description = "Clears the Bolb Chairs servers, ready for the next round.")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) {
        if (author.isServerAdmin()) {

            // Get all servers
            Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();
            Server bc6 = api.getServerById(BOLB_CHAIRS_6).get();

            // Get all server roles
            Role bc1watchers = bc1.getRoleById("428280838996623380").get();
            Role bc1cleaners = bc1.getRoleById("428280823595139093").get();
            Role bc2watchers = bc2.getRolesByNameIgnoreCase("Watchers").get(0);
            Role bc2cleaners = bc2.getRolesByNameIgnoreCase("Cleaners").get(0);
            Role bc3watchers = bc3.getRolesByNameIgnoreCase("Watchers").get(0);
            Role bc3cleaners = bc3.getRolesByNameIgnoreCase("Cleaners").get(0);
            Role bc4watchers = bc4.getRolesByNameIgnoreCase("Watchers").get(0);
            Role bc4cleaners = bc4.getRolesByNameIgnoreCase("Cleaners").get(0);
            Role bc5watchers = bc5.getRolesByNameIgnoreCase("Watchers").get(0);
            Role bc5cleaners = bc5.getRolesByNameIgnoreCase("Cleaners").get(0);
            Role bc6bolbs = bc6.getRolesByNameIgnoreCase("Bolbs").get(0);

            // Get all channels and prune them
            api.getTextChannelById(BC1_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
            api.getTextChannelById(BC2_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
            api.getTextChannelById(BC3_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
            api.getTextChannelById(BC4_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
            api.getTextChannelById(BC5_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));
            api.getTextChannelById(BC6_GENERAL).ifPresent(channel -> channel.getMessages(100000).thenCompose(MessageSet::deleteAll));

            // Kick all members without a role
            for (User member : bc1.getMembers()) {
                if (!member.getRoles(bc1).contains(bc1watchers) || !member.getRoles(bc1).contains(bc1cleaners)) {
                    bc1.kickUser(member);
                }
            }
            for (User member : bc2.getMembers()) {
                if (!member.getRoles(bc2).contains(bc2watchers) || !member.getRoles(bc2).contains(bc2cleaners)) {
                    bc2.kickUser(member);
                }
            }
            for (User member : bc3.getMembers()) {
                if (!member.getRoles(bc3).contains(bc3watchers) || !member.getRoles(bc3).contains(bc3cleaners)) {
                    bc3.kickUser(member);
                }
            }
            for (User member : bc4.getMembers()) {
                if (!member.getRoles(bc4).contains(bc4watchers) || !member.getRoles(bc4).contains(bc4cleaners)) {
                    bc4.kickUser(member);
                }
            }
            for (User member : bc5.getMembers()) {
                if (!member.getRoles(bc5).contains(bc5watchers) || !member.getRoles(bc5).contains(bc5cleaners)) {
                    bc5.kickUser(member);
                }
            }
            for (User member : bc6.getMembers()) {
                if (!member.getRoles(bc5).contains(bc6bolbs)) {
                    bc6.kickUser(member);
                } else return;
            }

            message.addReaction("\uD83D\uDC4D");
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
