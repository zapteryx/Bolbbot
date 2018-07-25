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

public class ClearInviteCommand implements CommandExecutor {

    @Command(aliases = {",clearinv"}, usage = ",clearinv", description = "Clears all invites.")
    public void onCommand(DiscordApi api, Message message, MessageAuthor author) throws InterruptedException {
        if (author.isServerAdmin()) {
            // Get all servers
            Server bchub = api.getServerById(BOLB_CHAIRS_HUB).get();
            Server bc1srv = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2srv = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3srv = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4srv = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5srv = api.getServerById(BOLB_CHAIRS_5).get();
            Server bc6srv = api.getServerById(BOLB_CHAIRS_6).get();

            // Clear invites
            bc1srv.getInvites().join().forEach(Invite::delete);
            bc2srv.getInvites().join().forEach(Invite::delete);
            bc3srv.getInvites().join().forEach(Invite::delete);
            bc4srv.getInvites().join().forEach(Invite::delete);
            bc5srv.getInvites().join().forEach(Invite::delete);
            bc6srv.getInvites().join().forEach(Invite::delete);

            message.addReaction("\uD83D\uDC4D");
        } else message.delete();
    }
}
