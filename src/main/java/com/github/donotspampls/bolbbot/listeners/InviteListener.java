package com.github.donotspampls.bolbbot.listeners;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class InviteListener implements MessageCreateListener {

    private DiscordApi api;

    public InviteListener(DiscordApi api) {
        this.api = api;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent ev) {
        // really stupid code
        if (!ev.getServer().get().getName().equals("Bolb Chairs Hub")) {
            if (!ev.getMessage().getAuthor().canCreateInstantInviteToTextChannel()) {
                if (ev.getMessage().getContent().startsWith("https://discord.gg") | ev.getMessage().getContent().startsWith("https://discordapp.com/invite")) {
                    ev.getMessage().delete();
                    ev.getChannel().sendMessage("<@" + ev.getMessage().getAuthor().getId() + "> - Please do not post invites to other servers here!");
                }
            }
        }
    }
}
