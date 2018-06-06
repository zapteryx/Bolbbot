package com.github.donotspampls.bolbbot.listeners;

import com.github.donotspampls.bolbbot.Constants;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import static com.github.donotspampls.bolbbot.Constants.BOLB_CHAIRS_HUB;

public class ServerJoinListener implements ServerMemberJoinListener {

    private DiscordApi api;
    private int bc1count = 0;
    private int bc2count = 0;
    private int bc3count = 0;
    private int bc4count = 0;
    private int bc5count = 0;
    private int bc6count = 0;

    public ServerJoinListener(DiscordApi api) {
        this.api = api;
    }

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent ev) {
        // Get related server names, users and servers
        String name = ev.getServer().getName();
        User user = ev.getUser();
        Server server = ev.getServer();
        Server bchub = api.getServerById(BOLB_CHAIRS_HUB).get();

        // Send a join message if a user has joined the server.
        if (user.getRoles(bchub).stream().anyMatch(role -> role.getName().contains("Watchers"))) return;
        else {
            switch (name) {
                case "Bolb Chairs Hub":
                    return;
                case "Bolb Chairs #1":
                    bc1count = bc1count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc1count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #2":
                    bc2count = bc2count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc2count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #3":
                    bc3count = bc3count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc3count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #4":
                    bc4count = bc4count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc4count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #5":
                    bc5count = bc5count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc5count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #6":
                    bc1count = 0;
                    bc2count = 0;
                    bc3count = 0;
                    bc4count = 0;
                    bc5count = 0;
                    bc6count = bc6count + 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc6count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #7":
                    return;
            }
        }

        // Assign roles.
        if (user.getMutualServers().stream().anyMatch(server1 -> server1.getName().equalsIgnoreCase("Bolb Chairs Hub"))) {
            switch (name) {
                case "Bolb Chairs #1":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326005020655636")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case "Bolb Chairs #2":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326003771015180")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case "Bolb Chairs #3":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326002944737282")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case "Bolb Chairs #4":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326002563055616")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case "Bolb Chairs #5":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326001606623232")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case "Bolb Chairs #6":
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById("445326000167976962")).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
            }
        }
    }
}
