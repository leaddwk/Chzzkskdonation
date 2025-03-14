package me.taromati.doneconnector.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.skriptlang.skript.lang.converter.Converters;
import me.taromati.doneconnector.Logger;

public class SkriptSupport {

    public static void registerSkript() {
        Plugin skript = Bukkit.getPluginManager().getPlugin("Skript");
        if (skript == null) {
            Logger.warn("Skript not found, skipping Skript integration");
            return;
        }

        // Register the ChzzkDonationEvent for Skript
        Skript.registerEvent("chzzk donation", SimpleEvent.class, ChzzkDonationEvent.class,
                "chzzk donation");

        // Register expressions to get donation information
        Skript.registerExpression(ExprDonationTag.class, String.class, ExpressionType.SIMPLE,
                "chzzk donation tag");
        Skript.registerExpression(ExprDonationNickname.class, String.class, ExpressionType.SIMPLE,
                "chzzk donation nickname");
        Skript.registerExpression(ExprDonationAmount.class, Integer.class, ExpressionType.SIMPLE,
                "chzzk donation amount");
        Skript.registerExpression(ExprDonationMessage.class, String.class, ExpressionType.SIMPLE,
                "chzzk donation message");

        // Register event values using the new Converter API
        EventValues.registerEventValue(ChzzkDonationEvent.class, String.class,
                event -> event.getNickname(), 0);

        // Register other useful event values
        EventValues.registerEventValue(ChzzkDonationEvent.class, String.class,
                event -> event.getTag(), 0);
        EventValues.registerEventValue(ChzzkDonationEvent.class, Integer.class,
                event -> event.getAmount(), 0);
        EventValues.registerEventValue(ChzzkDonationEvent.class, String.class,
                event -> event.getMessage(), 0);

        Logger.info("Skript support registered successfully");
    }
}