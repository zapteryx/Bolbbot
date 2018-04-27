package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
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
            Role bc1watchers = bc1.getRoleById("428280838996623380").get();
            Role bc1cleaners = bc1.getRoleById("428280823595139093").get();
            Role bc2watchers = bc2.getRoleById("428281144820105216").get();
            Role bc2cleaners = bc2.getRoleById("428281125559861261").get();
            Role bc3watchers = bc3.getRoleById("428281665610055681").get();
            Role bc3cleaners = bc3.getRoleById("428281655690657803").get();
            Role bc4watchers = bc4.getRoleById("428281725509173249").get();
            Role bc4cleaners = bc4.getRoleById("428281715757154317").get();
            Role bc5watchers = bc5.getRoleById("428277964367462441").get();
            Role bc5cleaners = bc5.getRoleById("428277950048239637").get();
            Role bc6bolbs = bc6.getRoleById("428276912318840834").get();

            // Get all channels and prune them
            bc1.getChannelsByName("spam").get(0).delete();
            bc1.createTextChannelBuilder().setName("spam").create();
            bc2.getChannelsByName("memes").get(0).delete();
            bc2.createTextChannelBuilder().setName("spam").create();
            bc3.getChannelsByName("colon-bolbchair-colon").get(0).delete();
            bc3.createTextChannelBuilder().setName("colon-bolbchair-colon").create();
            bc4.getChannelsByName("do-you-like-nitro").get(0).delete();
            bc4.createTextChannelBuilder().setName("do-you-like-nitro").create();
            bc5.getChannelsByName("this-is-not-stressful").get(0).delete();
            bc5.createTextChannelBuilder().setName("this-is-not-stressful").create();
            bc6.getChannelsByName("no-free-nitro-here").get(0).delete();
            bc6.createTextChannelBuilder().setName("no-free-nitro-here").create();

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
