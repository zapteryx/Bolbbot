package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.server.invite.InviteBuilder;

import static com.github.donotspampls.bolbbot.Constants.*;

public class GenInviteCommand implements CommandExecutor {

    @Command(aliases = {",geninvite"}, usage = ",geninvite <server> [uses]", description = "Generates an invite for a chosen Bolb Chairs server.")
    public void onCommand(DiscordApi api, String[] args, TextChannel channel, MessageAuthor author, Message message) {
        if (author.canManageRolesOnServer()) {
            if (args[0].equals("1")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC1_INFO).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else if (args[0].equals("2")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC2_INFO).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else if (args[0].equals("3")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC3_GENERAL).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else if (args[0].equals("4")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC4_GENERAL).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else if (args[0].equals("5")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC5_GENERAL).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else if (args[0].equals("6")) {
                try {
                    InviteBuilder builder = api.getServerChannelById(BC6_GENERAL).get().createInviteBuilder();
                    int uses = Integer.parseInt(args[1]);

                    builder.setNeverExpire();
                    builder.setMaxUses(uses);
                    String invite = builder.create().get().getUrl().toString();
                    channel.sendMessage("Invite for **Bolb Chairs #" + args[0] + "**: " + invite + " (" + args[1] + " uses)");
                } catch (Exception e) {}
            } else {
                message.addReaction("⚠");
            }
        } else {
            message.addReaction("\uD83D\uDEAB");
        }
    }

}
