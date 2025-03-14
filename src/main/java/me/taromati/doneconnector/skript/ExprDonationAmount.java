package me.taromati.doneconnector.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

// Amount Expression
public class ExprDonationAmount extends SimpleExpression<Integer> {

    static {
        try {
            if (Skript.isAcceptRegistrations()) {
                Skript.registerExpression(ExprDonationAmount.class, Integer.class, ExpressionType.SIMPLE,
                        "chzzk donation amount");
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
    protected Integer[] get(Event event) {
        if (!(event instanceof ChzzkDonationEvent donationEvent))
            return null;
        return new Integer[] { donationEvent.getAmount() };
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "chzzk donation amount";
    }
}