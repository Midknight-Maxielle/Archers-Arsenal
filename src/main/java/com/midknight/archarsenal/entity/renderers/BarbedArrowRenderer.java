package com.midknight.archarsenal.entity.renderers;

import com.midknight.archarsenal.entity.BarbedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class BarbedArrowRenderer extends ArrowRenderer<BarbedArrow> {

    public static final ResourceLocation ARROW_TEXTURE = new ResourceLocation("archarsenal:textures/entity/barbed_arrow.png");

    public BarbedArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override @Nonnull @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(BarbedArrow entity) {
        return ARROW_TEXTURE;
    }
}
