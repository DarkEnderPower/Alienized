package com.darkenderhilda.alienized.foundation.ui.utils;

import com.darkenderhilda.alienized.AllColors;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiRender {

    public static void drawModGuiBackground(GuiScreen guiScreen) {
        drawModGuiBackground(guiScreen, AllColors.TINT);
    }

    public static void drawModGuiBackground(GuiScreen guiScreen, Color c) {
        drawRect(0, 0, guiScreen.width, guiScreen.height, 0, c);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.GuiScreenEvent.BackgroundDrawnEvent(guiScreen));
    }

    /**
     * Draw border Around given area
     */
    public static void drawBorder(Area area, float thickness, int z, Color c) {
        //top
        drawRect(area.getX() - thickness, area.getY() - thickness, area.getWidth() + thickness * 2, thickness, z, c);
        //left
        drawRect(area.getX() - thickness, area.getY(), thickness, area.getHeight(), z, c);
        //bottom
        drawRect(area.getX() - thickness, area.getY() + area.getHeight(), area.getWidth() + thickness * 2, thickness, z, c);
        //right
        drawRect(area.getX() + area.getWidth(), area.getY(), thickness, area.getHeight(), z, c);
    }


    public static void drawRect(float x, float y, float w, float h, float z, Color c) {
        int color = c.getRGB();
        float r = (float)(color >> 24 & 255) / 255.0F;
        float g = (float)(color >> 16 & 255) / 255.0F;
        float b = (float)(color >> 8 & 255) / 255.0F;
        float a = (float)(color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        GlStateManager.disableLighting();

        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(g, b, a, r);
        buildCubeBox(bufferBuilder, x, y, w, h, z);
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }


    public static void buildCubeBox(BufferBuilder bufferBuilder, float x, float y, float w, float h, float z) {
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(x, y + h, z).endVertex();
        bufferBuilder.pos(x + w, y + h, z).endVertex();
        bufferBuilder.pos(x + w, y, z).endVertex();
        bufferBuilder.pos(x, y, z).endVertex();
    }
}
