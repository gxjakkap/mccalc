package me.guntxjakka.mccalc;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.guntxjakka.mccalc.commands.*;

public class McCalc implements ClientModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("mccalc");

	@Override
	public void onInitializeClient() {
		ClientCommandRegistrationCallback.EVENT.register(McCalc::registerCommands);
	}

	public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess){
		Calc.register(dispatcher);
	}
}
