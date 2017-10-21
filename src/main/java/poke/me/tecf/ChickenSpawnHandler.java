package poke.me.tecf;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Poke on 2017-10-21.
 */
public class ChickenSpawnHandler
{
    @SubscribeEvent
    public void onEntitySpawn(LivingSpawnEvent.CheckSpawn event)
    {
        if(!event.getWorld().isRemote)
        {
            if(!event.isSpawner())
            {
                if (event.getEntity() instanceof EntityChicken)
                {
                    EntityItem egg = new EntityItem(event.getWorld(),event.getX(),event.getY() + 1,event.getZ(),new ItemStack(Items.EGG,1,0));
                    event.getWorld().spawnEntity(egg);
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
