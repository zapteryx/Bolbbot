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
        String name = ev.getServer().getIdAsString();
        User user = ev.getUser();
        Server server = ev.getServer();

        Server bchub = api.getServerById(BOLB_CHAIRS_HUB).get();
        Server bc1srv = api.getServerById(BOLB_CHAIRS_1).get();
        Server bc2srv = api.getServerById(BOLB_CHAIRS_2).get();
        Server bc3srv = api.getServerById(BOLB_CHAIRS_3).get();
        Server bc4srv = api.getServerById(BOLB_CHAIRS_4).get();
        Server bc5srv = api.getServerById(BOLB_CHAIRS_5).get();
        Server bc6srv = api.getServerById(BOLB_CHAIRS_6).get();
        Role bchwatchers = bchub.getRoleById(BCH_WATCHERS).get();
        Role bchcleaners = bchub.getRoleById(BCH_CLEANERS).get();
        Role bchbolbs = bchub.getRoleById(BCH_BOLBS).get();
        
        // Send a join message if a user has joined the server.
        if (user.getRoles(bchub).stream().anyMatch(r -> r.equals(bchwatchers) || r.equals(bchcleaners) || r.equals(bchbolbs))) return;
        else {
            switch (name) {
                case BOLB_CHAIRS_1:
                    bc1count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc1count + "** to join the **" + server.getName() + "** server!"));
                    if (bc1count == 1) api.updateActivity("a Bolb Chairs round", ActivityType.WATCHING);
                    break;
                case BOLB_CHAIRS_2:
                    bc2count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc2count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case BOLB_CHAIRS_3:
                    bc3count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc3count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case BOLB_CHAIRS_4:
                    bc4count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc4count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case BOLB_CHAIRS_5:
                    bc5count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc5count + "** to join the **" + server.getName() + "** server!"));
                    break;
                case BOLB_CHAIRS_6:
                    bc1count = 0;
                    bc2count = 0;
                    bc3count = 0;
                    bc4count = 0;
                    bc5count = 0;
                    bc6count += 1;
                    api.getTextChannelById(Constants.GAME_LOGS).ifPresent(textChannel -> textChannel.sendMessage("\uD83D\uDCE5 **" + user.getDiscriminatedName() + "** `" + user.getIdAsString() + "` is **#" + bc6count + "** to join the **" + server.getName() + "** server!"));
                    api.updateActivity(user.getName() + "'s victory \uD83C\uDF89", ActivityType.WATCHING);
                    break;
                default: return;
            }
        }

        // Assign roles.
        if (user.getMutualServers().stream().anyMatch(server1 -> server1.getIdAsString().equals(BOLB_CHAIRS_HUB))) {
            switch (name) {
                case BOLB_CHAIRS_1:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC1)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case BOLB_CHAIRS_2:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC2)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case BOLB_CHAIRS_3:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC3)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case BOLB_CHAIRS_4:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC4)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case BOLB_CHAIRS_5:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC5)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                case BOLB_CHAIRS_6:
                    api.getServerById(BOLB_CHAIRS_HUB).flatMap(bch -> bch.getRoleById(BC6)).ifPresent(role -> role.getServer().addRoleToUser(user, role));
                    break;
                default:
            }
        }

        // Check if a server is full
        if (server.getIdAsString().equals(BOLB_CHAIRS_1) && bc1count == bc1limit) {
            bc1srv.getInvites().join().forEach(Invite::delete);
            api.getTextChannelById(BC1_INFO).ifPresent(textChannel -> textChannel.sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40"));
        }
        if (server.getIdAsString().equals(BOLB_CHAIRS_2) && bc2count == bc2limit) {
            bc2srv.getInvites().join().forEach(Invite::delete);
            api.getTextChannelById(BC2_INFO).ifPresent(textChannel -> textChannel.sendMessage("@everyone This server is now full! Get ready for the next invite \uD83D\uDC40"));
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
            SayCommand.broadcast("@everyone We now have a winner! Congratulations to " + user.getMentionTag() + " on winning this round of Bolb Chairs!", api);
            bc6count = 0;
        }

    }
}
