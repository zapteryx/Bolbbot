package com.github.donotspampls.bolbbot.listeners;

import com.github.donotspampls.bolbbot.Constants;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;

import java.util.Optional;

import static com.github.donotspampls.bolbbot.Constants.*;
import static com.github.donotspampls.bolbbot.Constants.BOLB_CHAIRS_5;

public class ServerLeaveListener implements ServerMemberLeaveListener {

    private DiscordApi api;
    private Optional<TextChannel> gameLogsChannel;

    public ServerLeaveListener(DiscordApi api) {
        gameLogsChannel = api.getTextChannelById(Constants.GAME_LOGS);
        this.api = api;
    }

    @Override
    public void onServerMemberLeave(ServerMemberLeaveEvent ev) {
        if (ev.getServer().getName() == "Bolb Chairs Hub") return;
        else {
            User user = ev.getUser();

            Server bc1 = api.getServerById(BOLB_CHAIRS_1).get();
            Server bc2 = api.getServerById(BOLB_CHAIRS_2).get();
            Server bc3 = api.getServerById(BOLB_CHAIRS_3).get();
            Server bc4 = api.getServerById(BOLB_CHAIRS_4).get();
            Server bc5 = api.getServerById(BOLB_CHAIRS_5).get();

            bc1.banUser(user);
            bc2.banUser(user);
            bc3.banUser(user);
            bc4.banUser(user);
            bc5.banUser(user);

            gameLogsChannel.get().sendMessage("\uD83D\uDD28 **[AUTO]** Cross-banned **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` from the **Bolb Chairs** game servers.");
        }
    }

}
