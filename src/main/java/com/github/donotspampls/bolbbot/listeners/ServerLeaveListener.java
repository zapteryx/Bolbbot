package com.github.donotspampls.bolbbot.listeners;

import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;

import static com.github.donotspampls.bolbbot.Constants.*;

public class ServerLeaveListener implements ServerMemberLeaveListener {

    @Override
    public void onServerMemberLeave(ServerMemberLeaveEvent ev) {
        String name = ev.getServer().getName();
        switch (name) {
            case "Bolb Chairs #1":
                bc1count -= 1;
                break;
            case "Bolb Chairs #2":
                bc2count -= 1;
                break;
            case "Bolb Chairs #3":
                bc3count -= 1;
                break;
            case "Bolb Chairs #4":
                bc4count -= 1;
                break;
            case "Bolb Chairs #5":
                bc5count -= 1;
                break;
        }
    }

}
