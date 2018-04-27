package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.server.invite.InviteBuilder;

import java.util.concurrent.ExecutionException;

import static com.github.donotspampls.bolbbot.Constants.*;

public class GenInviteCommand implements CommandExecutor {

    @Command(aliases = {",geninvite"}, usage = ",geninvite <server> [uses]", description = "Generates an invite for a chosen Bolb Chairs server.")
    public void onCommand(DiscordApi api, String[] args, TextChannel channel, MessageAuthor author, Message message) {
        if (author.canManageRolesOnServer()) {
            int uses = Integer.parseInt(args[1]);

            switch (args[0]) {
                case "1":
                    api.getServerChannelById(BC1_INFO).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                case "2":
                    api.getServerChannelById(BC2_INFO).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                case "3":
                    api.getServerChannelById(BC3_GENERAL).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                case "4":
                    api.getServerChannelById(BC4_GENERAL).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                case "5":
                    api.getServerChannelById(BC5_GENERAL).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                case "6":
                    api.getServerChannelById(BC6_GENERAL).ifPresent(serverChannel -> {
                        String invite = createInvite(uses, serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                    });
                    break;
                default:
                    message.addReaction("⚠");
                    break;
            }
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

    private String createInvite(Integer uses, ServerChannel channel) {
        try {
            InviteBuilder builder = channel.createInviteBuilder();
            builder.setNeverExpire();
            builder.setMaxUses(uses);
            return builder.create().get().getUrl().toString();
        } catch (InterruptedException | ExecutionException ignored) {}
        return "";
    }
}
