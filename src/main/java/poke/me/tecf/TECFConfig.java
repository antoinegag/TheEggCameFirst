package poke.me.tecf;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Poke on 2017-10-21.
 */
public class TECFConfig
{
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPECIFICATION;

    static
    {
        Pair<ServerConfig, ForgeConfigSpec> specificationPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPECIFICATION = specificationPair.getRight();
        SERVER = specificationPair.getLeft();
    }

    public static class ServerConfig
    {
        public final ForgeConfigSpec.IntValue eggSpawnAmount;

        ServerConfig(ForgeConfigSpec.Builder builder)
        {
            eggSpawnAmount = builder
                    .comment("Sets the amount of eggs that should spawn where a chicken would have. Default: 1\"")
                    .defineInRange("eggSpawnAmount", 1, 1, Integer.MAX_VALUE);
        }
    }
}
