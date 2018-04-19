package com.github.donotspampls.bolbbot.listeners;

import com.github.donotspampls.bolbbot.Constants;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static com.github.donotspampls.bolbbot.Constants.*;

public class ServerJoinListener implements ServerMemberJoinListener {

    private DiscordApi api;
    private Optional<TextChannel> gameLogsChannel;
    private int bc1count = 0;
    private int bc2count = 0;
    private int bc3count = 0;
    private int bc4count = 0;
    private int bc5count = 0;
    private int bc6count = 0;

    public ServerJoinListener(DiscordApi api) {
        gameLogsChannel = api.getTextChannelById(Constants.GAME_LOGS);
        this.api = api;
    }

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent ev) {
        // Get related server names, users and servers
        String name = ev.getServer().getName();
        User user = ev.getUser();
        Server server = ev.getServer();
        Server bch = api.getServerById(BOLB_CHAIRS_HUB).get();

        // Get role IDs in Bolb Chairs Hub
        Role bc1 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #1").get(0);
        Role bc2 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #2").get(0);
        Role bc3 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #3").get(0);
        Role bc4 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #4").get(0);
        Role bc5 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #5").get(0);
        Role bc6 = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #6").get(0);

        // Send a join message if a user has joined the server.
        switch (name) {
            case "Bolb Chairs Hub":
                return;
            case "Bolb Chairs #1":
                bc1count = bc1count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc1count + "** to join the **" + server.getName() + "** server!");
                break;
            case "Bolb Chairs #2":
                bc2count = bc2count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc2count + "** to join the **" + server.getName() + "** server!");
                break;
            case "Bolb Chairs #3":
                bc3count = bc3count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc3count + "** to join the **" + server.getName() + "** server!");
                break;
            case "Bolb Chairs #4":
                bc4count = bc4count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc4count + "** to join the **" + server.getName() + "** server!");
                break;
            case "Bolb Chairs #5":
                bc5count = bc5count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc5count + "** to join the **" + server.getName() + "** server!");
                break;
            case "Bolb Chairs #6":
                bc6count = bc6count + 1;
                gameLogsChannel.get().sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc6count + "** to join the **" + server.getName() + "** server!");
                break;
        }

        // Assign roles.
        if (!user.getMutualServers().contains("Bolb Chairs Hub")) {
            switch (name) {
                case "Bolb Chairs #1":
                    bch.addRoleToUser(user, bc1);
                    break;
                case "Bolb Chairs #2":
                    bch.addRoleToUser(user, bc2);
                    break;
                case "Bolb Chairs #3":
                    bch.addRoleToUser(user, bc3);
                    break;
                case "Bolb Chairs #4":
                    bch.addRoleToUser(user, bc4);
                    break;
                case "Bolb Chairs #5":
                    bch.addRoleToUser(user, bc5);
                    break;
                case "Bolb Chairs #6":
                    bch.addRoleToUser(user, bc6);
                    break;
            }
        }
    }
}
