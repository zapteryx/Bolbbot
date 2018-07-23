package com.github.donotspampls.bolbbot.listeners;

import com.github.donotspampls.bolbbot.Constants;
import com.github.donotspampls.bolbbot.commands.CrossBanCommand;
import com.github.donotspampls.bolbbot.commands.SayCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.invite.Invite;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import static com.github.donotspampls.bolbbot.Constants.*;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.permission.Role;

public class ServerJoinListener implements ServerMemberJoinListener {

    private DiscordApi api;
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
        Server bc1srv = api.getServerById(BOLB_CHAIRS_1).get();
        Server bc2srv = api.getServerById(BOLB_CHAIRS_2).get();
        Server bc3srv = api.getServerById(BOLB_CHAIRS_3).get();
        Server bc4srv = api.getServerById(BOLB_CHAIRS_4).get();
        Server bc5srv = api.getServerById(BOLB_CHAIRS_5).get();
        Server bc6srv = api.getServerById(BOLB_CHAIRS_6).get();
        Role bchwatchers = bchub.getRoleById("445258332391997440").get();
        Role bchcleaners = bchub.getRoleById("445258337781547030").get();
        Role bchbolbs = bchub.getRoleById("445257662662180898").get();
        
        // Send a join message if a user has joined the server.
        if (user.getRoles(bchub).stream().anyMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))) return;
        else {
            switch (name) {
                case "Bolb Chairs #1":
                    bc1count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc1count + "** to join the **" + server.getName() + "** server!"));
                    api.updateActivity("a Bolb Chairs round", ActivityType.WATCHING);
                    break;
                case "Bolb Chairs #2":
                    bc2count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc2count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #3":
                    bc3count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc3count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #4":
                    bc4count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc4count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #5":
                    bc5count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc5count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case "Bolb Chairs #6":
                    bc1count = 0;
                    bc2count = 0;
                    bc3count = 0;
                    bc4count = 0;
                    bc5count = 0;
                    bc6count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc6count + "** to join the **" + server.getName() + "** server!"));
                    api.updateActivity(user.getDiscriminatedName() + "'s victory", ActivityType.WATCHING);
                    break;
                default: return;
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
                default:
            }
        }

        // Check if a server is full
        if (server.getIdAsString().equals(BOLB_CHAIRS_1) && bc1count == bc1limit) {
            bc1srv.getInvites().join().forEach(Invite::delete);
            api.getTextChannelById("453889454814265347").ifPresent(textChannel -> textChannel.sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40"));
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_2) && bc2count == bc2limit) {
            bc2srv.getInvites().join().forEach(Invite::delete);
            api.getTextChannelById("453889514381770754").ifPresent(textChannel -> textChannel.sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40"));
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_3) && bc3count == bc3limit) {
            bc3srv.getInvites().join().forEach(Invite::delete);
            bc3srv.getTextChannelsByName(BC3_CHANNEL).get(0).sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40");
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_4) && bc4count == bc4limit) {
            bc4srv.getInvites().join().forEach(Invite::delete);
            bc4srv.getTextChannelsByName(BC4_CHANNEL).get(0).sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40");
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_5) && bc5count == bc5limit) {
            bc5srv.getInvites().join().forEach(Invite::delete);
            bc5srv.getTextChannelsByName(BC5_CHANNEL).get(0).sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40");
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_6) && bc6count == 1) {
            bc6srv.getInvites().join().forEach(Invite::delete);
            SayCommand.broadcast("@everyone We now have a winner! Congratulations to **" + user.getDiscriminatedName() + "** on winning this round of Bolb Chairs!", api);
            bc6count = 0;
        }

    }
}
