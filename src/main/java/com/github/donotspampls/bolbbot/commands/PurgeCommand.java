package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.concurrent.TimeUnit;

import static com.github.donotspampls.bolbbot.Constants.*;
import org.javacord.api.entity.activity.ActivityType;

public class PurgeCommand implements CommandExecutor {

    @Command(aliases = {",purge"}, usage = ",purge", description = "Clears the Bolb Chairs servers, ready for the next round.")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) throws InterruptedException {
        if (author.isServerAdmin()) {
            // Get all servers
            message.addReaction("\u231B");
            Server bch = api.getServerById(BOLB_CHAIRS_HUB).get();
            Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();
            Server bc6 = api.getServerById(BOLB_CHAIRS_6).get();

            // Get roles from the hub
            Role bchwatchers = bch.getRoleById("445258332391997440").get();
            Role bchcleaners = bch.getRoleById("445258337781547030").get();
            Role bchbolbs = bch.getRoleById("445257662662180898").get();

            // Get all channels and prune them
            bc1.getChannelsByName(BC1_CHANNEL).get(0).delete();
            bc1.createTextChannelBuilder().setName(BC1_CHANNEL).create();

            bc2.getChannelsByName(BC2_CHANNEL).get(0).delete();
            bc2.createTextChannelBuilder().setName(BC2_CHANNEL).create();

            bc3.getChannelsByName(BC3_CHANNEL).get(0).delete();
            bc3.createTextChannelBuilder().setName(BC3_CHANNEL).create();

            bc4.getChannelsByName(BC4_CHANNEL).get(0).delete();
            bc4.createTextChannelBuilder().setName(BC4_CHANNEL).create();

            bc5.getChannelsByName(BC5_CHANNEL).get(0).delete();
            bc5.createTextChannelBuilder().setName(BC5_CHANNEL).create();

            bc6.getChannelsByName(BC6_CHANNEL).get(0).delete();
            bc6.createTextChannelBuilder().setName(BC6_CHANNEL).create();
            
            // Set playing status
            api.updateActivity("lobby music", ActivityType.LISTENING);

            // Kick all members without a role
            bc1.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc1::kickUser);
            bc2.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc2::kickUser);
            bc3.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc3::kickUser);
            bc4.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc4::kickUser);
            bc5.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc5::kickUser);
            bc6.getMembers().stream().filter(member -> member.getRoles(bch).stream().noneMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))).forEach(bc6::kickUser);

            // Reset limit
            bc1limit = 30;
            bc2limit = 15;
            bc3limit = 10;
            bc4limit = 5;
            bc5limit = 3;
            
            // Set welcome message channels (delayed by 5 seconds to fix some issues)
            TimeUnit.SECONDS.sleep(5);
            setMembers(api);

            message.addReaction("\uD83D\uDC4D");
        } else message.delete();
    }

    private void setMembers(DiscordApi api) {
        Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
        Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
        Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
        Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
        Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();
        Server bc6 = api.getServerById(BOLB_CHAIRS_6).get();

        bc1.setSystemChannel(bc1.getChannelsByName(BC1_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
        bc2.setSystemChannel(bc2.getChannelsByName(BC2_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
        bc3.setSystemChannel(bc3.getChannelsByName(BC3_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
        bc4.setSystemChannel(bc4.getChannelsByName(BC4_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
        bc5.setSystemChannel(bc5.getChannelsByName(BC5_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
        bc6.setSystemChannel(bc6.getChannelsByName(BC6_CHANNEL).get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
    }

}
