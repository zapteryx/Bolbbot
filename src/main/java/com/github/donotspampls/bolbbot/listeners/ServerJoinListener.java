package com.github.donotspampls.bolbbot.listeners;

import com.github.donotspampls.bolbbot.Constants;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import java.util.Optional;

public class ServerJoinListener implements ServerMemberJoinListener {

    private DiscordApi api;
    private Optional<TextChannel> gameLogsChannel;

    public ServerJoinListener(DiscordApi api) {
        gameLogsChannel = api.getTextChannelById(Constants.GAME_LOGS);
        this.api = api;
    }

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent ev) {
        String name = ev.getServer().getName();
        User user = ev.getUser();
        Server server = ev.getServer();

        if (name.equals("Bolb Chairs Hub")) return;
        else {
            gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#0** to join the **" + server.getName() + "** server!");
        }
    }

}
