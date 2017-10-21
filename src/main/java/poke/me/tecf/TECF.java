package poke.me.tecf;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


/**
 * Created by Poke on 2017-10-21.
 */

@Mod(modid = TECF.MODID,name = TECF.MODNAME,version = TECF.MODVERSION)
public class TECF
{
    public static final String MODID = "tecf";
    public static final String MODNAME = "The Egg Came First";
    public static final String MODVERSION = "1.0";

    @Mod.Instance
    public static TECF instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
       MinecraftForge.EVENT_BUS.register(new ChickenSpawnHandler());
    }
}
