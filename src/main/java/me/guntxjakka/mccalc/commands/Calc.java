package me.guntxjakka.mccalc.commands;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import com.mojang.brigadier.CommandDispatcher;
import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;
import static me.guntxjakka.mccalc.lib.Eval.eval;
import static  me.guntxjakka.mccalc.lib.NumberOps.checkIfNumberIsInt;

public class Calc {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("calc")
                .then(argument("expression", string())
                        .executes(ctx -> {
                            calculateAns(ctx.getSource(), getString(ctx, "expression"));
                            return 1;
                        })));
    }
    private static void calculateAns(FabricClientCommandSource source, String expression){
        Double answer = eval(expression);
        String feedback = "[McCalc] ".concat(expression).concat(" = ");
        if (checkIfNumberIsInt(answer)){
            int ansInt = answer.intValue();
            source.sendFeedback(Text.literal(feedback.concat(String.valueOf(ansInt))));
        }
        else {
            source.sendFeedback(Text.literal(feedback.concat(String.valueOf(answer))));
        }
    }
}
