package com.github.donotspampls.bolbbot.listeners;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.concurrent.TimeUnit;

public class InviteListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent ev) {
        Server server = ev.getServer().get();
        Message msg = ev.getMessage();
        TextChannel channel = ev.getChannel();

        if (server.getName().equals("Bolb Chairs Hub")) {
            if (!msg.getAuthor().canCreateInstantInviteToTextChannel()) {
                if (msg.getContent().contains("discord.gg") | ev.getMessage().getContent().startsWith("https://discordapp.com/invite")) {
                    msg.delete();
                    channel.sendMessage("<@" + ev.getMessage().getAuthor().getId() + "> - Please do not post invites to other servers here!");
                }
            }
        }
    }

}
