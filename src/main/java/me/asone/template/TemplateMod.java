/*
 * This file is part of the TemplateMod project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2026  As_One and contributors
 *
 * TemplateMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TemplateMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with TemplateMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.asone.template;

//? if >1.18.2 {
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
//?} else {
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*///?}

//? fabric {
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
//?} elif forge {
/*import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModInfo;
*///?} elif neoforge {
/*import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforgespi.language.IModInfo;
*///?}

//? forgelike {
/*@Mod(TemplateMod.MOD_ID)
*///?}
public class TemplateMod
		//? fabric {
		implements ModInitializer
		//?}
{
	public static final Logger LOGGER =
			//? if >1.18.2 {
			LogUtils.getLogger();
			//?} else
			//LogManager.getLogger();

	public static final String MOD_ID = "template";
	public static String MOD_VERSION = "unknown";
	public static String MOD_NAME = "unknown";

	//? fabric {
	@Override
	public void onInitialize() {
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
		MOD_NAME = metadata.getName();
		MOD_VERSION = metadata.getVersion().getFriendlyString();
		LOGGER.info("Hello {} v{} from fabric!", MOD_NAME, MOD_VERSION);
		this.init();
	}

	//?} else {
	/*public TemplateMod() {
		IModInfo modInfo = ModList.get().getModContainerById(MOD_ID).orElseThrow(RuntimeException::new).getModInfo();
		MOD_NAME = modInfo.getDisplayName();
		MOD_VERSION = modInfo.getVersion().toString();
		LOGGER.info("Hello {} v{} from forge-like!", MOD_NAME, MOD_VERSION);
		this.init();
	}
	*///?}


	private void init() {
		// common init here
	}
}
