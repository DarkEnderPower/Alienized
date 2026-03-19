package com.darkenderhilda.alienized.foundation.ui.render.drawables;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class DrawableResource
        implements IDrawable {

    private final ResourceLocation location;

    public DrawableResource(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public void draw(float x, float y, float width, float height, int zLevel) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(location);
        GlStateManager.color(1, 1, 1, 1);

        float n = 1.0F / width;
        float o = 1.0F / height;

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);

        bufferBuilder
                .pos(x, (y + height), zLevel)
                .tex(0, (height * o))
                .endVertex();
        bufferBuilder
                .pos((x + width), (y + height), zLevel)
                .tex((width * n), (height * o))
                .endVertex();
        bufferBuilder
                .pos((x + width), y, zLevel)
                .tex((width * n), 0)
                .endVertex();
        bufferBuilder
                .pos(x, y, zLevel)
                .tex(0, 0)
                .endVertex();

        tessellator.draw();
    }
}
