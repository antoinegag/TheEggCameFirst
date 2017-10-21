package poke.me.tecf;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;


/**
 * Created by Poke on 2017-10-21.
 */

@Mod.EventBusSubscriber
@Mod(modid = TECF.MODID,name = TECF.MODNAME,version = TECF.MODVERSION)
public class TECF
{
    public static final String MODID = "tecf";
    public static final String MODNAME = "The Egg Came First";
    public static final String MODVERSION = "1.0";

    @Mod.Instance
    public static TECF instance;

    public static Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "tecf.cfg"));
        TECFConfig.readConfig();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void onEntitySpawn(LivingSpawnEvent.CheckSpawn event)
    {
        if(!event.getWorld().isRemote)
        {
            if(!event.isSpawner())
            {
                if (event.getEntity() instanceof EntityChicken)
                {
                    EntityItem egg = new EntityItem(event.getWorld(),event.getX(),event.getY() + 1,event.getZ(),new ItemStack(Items.EGG, TECFConfig.eggSpawnAmmount,0));
                    event.getWorld().spawnEntity(egg);
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
