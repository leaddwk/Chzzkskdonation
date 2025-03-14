package me.taromati.doneconnector.skript;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class ChzzkDonationEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final String tag;
    private final String nickname;
    private final int amount;
    private final String message;

    public ChzzkDonationEvent(String tag, String nickname, int amount, String message) {
        this.tag = tag;
        this.nickname = nickname;
        this.amount = amount;
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
