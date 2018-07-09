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
            switch (args[0]) {
                case "1":
                    api.getServerById(BOLB_CHAIRS_1).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC1_INFO).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #1**: " + invite);
                    });
                    break;
                case "2":
                    api.getServerById(BOLB_CHAIRS_2).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC2_INFO).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #2**: " + invite);
                    });
                    break;
                case "3":
                    api.getServerById(BOLB_CHAIRS_3).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC3_CHANNEL).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #3**: " + invite);
                    });
                    break;
                case "4":
                    api.getServerById(BOLB_CHAIRS_4).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC4_CHANNEL).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #4**: " + invite);
                    });
                    break;
                case "5":
                    api.getServerById(BOLB_CHAIRS_5).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC5_CHANNEL).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #5**: " + invite);
                    });
                    break;
                case "6":
                    api.getServerById(BOLB_CHAIRS_6).ifPresent(server -> {
                        ServerChannel serverChannel = server.getChannelsByName(BC6_CHANNEL).get(0);
                        String invite = createInvite(serverChannel);
                        channel.sendMessage("Invite for **Bolb Chairs #6**: " + invite);
                    });
                    break;
                default: {
                    message.addReaction("⚠");
                    break;
                }
            }
        } else message.delete();
    }

    private String createInvite(ServerChannel channel) {
        try {
            InviteBuilder builder = channel.createInviteBuilder();
            builder.setNeverExpire();
            builder.setMaxAgeInSeconds(86400);
            return builder.create().get().getUrl().toString();
        } catch (InterruptedException | ExecutionException ignored) {}
        return "error";
    }
}
