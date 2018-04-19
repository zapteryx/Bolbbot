package com.github.donotspampls.bolbbot.listeners;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;

import static com.github.donotspampls.bolbbot.Constants.*;

public class ServerLeaveListener implements ServerMemberLeaveListener {

    private DiscordApi api;

    public ServerLeaveListener(DiscordApi api) {
        this.api = api;
    }

    @Override
    public void onServerMemberLeave(ServerMemberLeaveEvent ev) {
        if (ev.getServer().getName().equals("Bolb Chairs Hub")) return;
        else {
            User user = ev.getUser();
            // Server server = ev.getServer();
            Server bch = api.getServerById(BOLB_CHAIRS_HUB).get();

            Role bc1role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #1").get(0);
            Role bc2role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #2").get(0);
            Role bc3role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #3").get(0);
            Role bc4role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #4").get(0);
            Role bc5role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #5").get(0);
            Role bc6role = api.getServerById(BOLB_CHAIRS_HUB).get().getRolesByNameIgnoreCase("Bolb Chairs #6").get(0);

            // server.banUser(user);

            if (bch.getRolesOf(user).contains(bc1role)) {
                bch.removeRoleFromUser(user, bc1role);
            } else if (user.getRoles(bch).contains(bc2role)) {
                bch.removeRoleFromUser(user, bc2role);
            } else if (user.getRoles(bch).contains(bc3role)) {
                bch.removeRoleFromUser(user, bc3role);
            } else if (user.getRoles(bch).contains(bc4role)) {
                bch.removeRoleFromUser(user, bc4role);
            } else if (user.getRoles(bch).contains(bc5role)) {
                bch.removeRoleFromUser(user, bc5role);
            } else if (user.getRoles(bch).contains(bc6role)) {
                bch.removeRoleFromUser(user, bc6role);
            }
        }
    }

}
