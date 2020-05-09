package poke.me.tecf;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

/**
 * Created by Poke on 2017-10-21.
 */
@Mod(TECF.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TECF
{
    public static final String MODID = "tecf";

    public TECF() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, TECFConfig.SERVER_SPECIFICATION);
    }

    @SubscribeEvent
    public static void onEntitySpawn(LivingSpawnEvent.CheckSpawn event)
    {
        if(!event.getWorld().isRemote())
        {
            if(!event.isSpawner())
            {
                if (event.getEntity() instanceof ChickenEntity)
                {
                    ItemEntity egg = new ItemEntity(event.getWorld().getWorld(), event.getX(), event.getY() + 1, event.getZ(),
                            new ItemStack(Items.EGG, TECFConfig.SERVER.eggSpawnAmount.get()));
                    event.getWorld().addEntity(egg);
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
