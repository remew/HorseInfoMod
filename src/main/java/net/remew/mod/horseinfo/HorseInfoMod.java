package net.remew.mod.horseinfo;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by remew on 2015/07/28.
 */
@Mod( modid = HorseInfoMod.MOD_ID, name = HorseInfoMod.MOD_NAME, version = HorseInfoMod.VERSION)
public class HorseInfoMod
{
	public static final String MOD_ID = "net.remew.mod.horseinfo";
	public static final String MOD_NAME = "HorseInfoMod by Remew";
	public static final String VERSION = "0.1a";

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register( new HorseInteractEvent() );
	}
}
