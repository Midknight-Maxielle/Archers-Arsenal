package com.midknight.archarsenal;

import com.midknight.archarsenal.entity.renderers.BarbedArrowRenderer;
import com.midknight.archarsenal.entity.renderers.VillagerArrowRenderer;
import com.midknight.archarsenal.util.KnightcoreBowModelProperties;
import com.midknight.archarsenal.util.registries.ModRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArchArsenal.MOD_ID)
public class ArchArsenal
{
    public static final String MOD_ID = "archarsenal";

    public ArchArsenal() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bowSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::arrowSetup);
        ModRegistry.registerENTITY();
        ModRegistry.registerITEM();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void arrowSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModRegistry.VILLAGER_ARROW_ENTITY.get(), VillagerArrowRenderer::new);
        event.registerEntityRenderer(ModRegistry.BARBED_ARROW_ENTITY.get(), BarbedArrowRenderer::new);
    }

    private void bowSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            KnightcoreBowModelProperties.makeBow(ModRegistry.BOW_LEATHER.get());
            KnightcoreBowModelProperties.makeBow(ModRegistry.BOW_IRON.get());
            KnightcoreBowModelProperties.makeBow(ModRegistry.BOW_GOLD.get());
            KnightcoreBowModelProperties.makeBow(ModRegistry.BOW_DIAMOND.get());
            KnightcoreBowModelProperties.makeBow(ModRegistry.BOW_NETHERITE.get());
        });
    }
}
