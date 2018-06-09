package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.server.Server;
import org.javacord.api.util.logging.ExceptionLogger;

import static com.github.donotspampls.bolbbot.Constants.*;

public class MembersCommand implements CommandExecutor {

    @Command(aliases = {",members"}, usage = ",members", description = "Sets new members channel (probably temporary command)")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) {
        if (author.isServerAdmin()) {
            Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();
            Server bc6 = api.getServerById(BOLB_CHAIRS_6).get();

            bc1.setSystemChannel(bc1.getChannelsByName("spam").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
            bc2.setSystemChannel(bc2.getChannelsByName("spam").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
            bc3.setSystemChannel(bc3.getChannelsByName("colon-bolbchair-colon").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
            bc4.setSystemChannel(bc4.getChannelsByName("do-you-like-nitro").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
            bc5.setSystemChannel(bc5.getChannelsByName("this-is-not-stressful").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());
            bc6.setSystemChannel(bc6.getChannelsByName("no-free-nitro-here").get(0).asServerTextChannel().get()).exceptionally(ExceptionLogger.get());

            message.addReaction("\uD83D\uDC4D");
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
