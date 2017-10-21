package poke.me.tecf;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Poke on 2017-10-21.
 */
@Config(modid = TECF.MODID)
public class TECFConfig
{
    @Config.Comment({"Sets the ammount of egg that should spawn where a chiken would have. Default: 1" })
    public static int eggSpawnAmmount = 1;

    private static final String CATEGORY_GENERAL = "general";

    public static void readConfig()
    {
        Configuration config = TECF.config;
        try
        {
            config.load();
            config.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
            eggSpawnAmmount = config.getInt("eggSpawnAmmount",CATEGORY_GENERAL, eggSpawnAmmount, 0, Integer.MAX_VALUE, "Sets the ammount of egg that should spawn where a chiken would have. Default: 1" );
        } catch (Exception e1)
        {
            System.out.println("Failed to read config file!");
            e1.printStackTrace();
        } finally
        {
            if(config.hasChanged())
                config.save();
        }
    }

}
