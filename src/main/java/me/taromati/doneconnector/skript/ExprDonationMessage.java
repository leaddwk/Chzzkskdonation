package me.taromati.doneconnector.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

// Message Expression
public class ExprDonationMessage extends SimpleExpression<String> {

    static {
        try {
            if (Skript.isAcceptRegistrations()) {
                Skript.registerExpression(ExprDonationMessage.class, String.class, ExpressionType.SIMPLE,
                        "chzzk donation message");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        return true;
    }

    @Override
    @Nullable
    protected String[] get(Event event) {
        if (!(event instanceof ChzzkDonationEvent donationEvent))
            return null;
        return new String[] { donationEvent.getMessage() };
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "chzzk donation message";
    }
}