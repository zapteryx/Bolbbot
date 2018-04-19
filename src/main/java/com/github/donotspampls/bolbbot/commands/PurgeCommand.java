package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;

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
            Role bc1watchers = bc1.getRolesByNameIgnoreCase("Watchers").get(0);
            Role bc1cleaners = bc1.getRolesByNameIgnoreCase("Cleaners").get(0);
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
            bc1.getMembers().stream().filter(member -> member.getRoles(bc1).stream().noneMatch(r -> r.equals(bc1cleaners) || r.equals(bc1watchers))).forEach(bc1::kickUser);
            bc2.getMembers().stream().filter(member -> member.getRoles(bc2).stream().noneMatch(r -> r.equals(bc2cleaners) || r.equals(bc2watchers))).forEach(bc1::kickUser);
            bc3.getMembers().stream().filter(member -> member.getRoles(bc3).stream().noneMatch(r -> r.equals(bc3cleaners) || r.equals(bc3watchers))).forEach(bc1::kickUser);
            bc4.getMembers().stream().filter(member -> member.getRoles(bc4).stream().noneMatch(r -> r.equals(bc4cleaners) || r.equals(bc4watchers))).forEach(bc1::kickUser);
            bc5.getMembers().stream().filter(member -> member.getRoles(bc5).stream().noneMatch(r -> r.equals(bc5cleaners) || r.equals(bc5watchers))).forEach(bc1::kickUser);
            bc6.getMembers().stream().filter(member -> member.getRoles(bc6).stream().noneMatch(r -> r.equals(bc6bolbs))).forEach(bc1::kickUser);

            message.addReaction("\uD83D\uDC4D");
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
