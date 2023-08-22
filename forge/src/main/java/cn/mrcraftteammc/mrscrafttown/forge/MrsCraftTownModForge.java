package cn.mrcraftteammc.mrscrafttown.forge;

import cn.mrcraftteammc.mrscrafttown.MrsCraftTownMod;
import cn.mrcraftteammc.mrscrafttown.config.MrCTForgeConfigger;
import dev.architectury.platform.forge.EventBuses;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cn.mrcraftteammc.mrscrafttown.MrsCraftTownMod.LOGGER;
import static cn.mrcraftteammc.mrscrafttown.MrsCraftTownMod.MOD_ID;

@Mod(MOD_ID)
public class MrsCraftTownModForge {
    public MrsCraftTownModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MrsCraftTownMod.init();
        LOGGER.info("Init Configger");
        MidnightConfig.init(MOD_ID, MrCTForgeConfigger.class);

        MrsCraftModForgeClient();
        MrsCraftModForgeServer();
    }

    @OnlyIn(Dist.CLIENT)
    public static void MrsCraftModForgeClient() {
        MrsCraftTownMod.initClient();
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void MrsCraftModForgeServer() {
        MrsCraftTownMod.initServer();
    }
}
