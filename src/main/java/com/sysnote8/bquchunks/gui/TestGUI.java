package com.sysnote8.bquchunks.gui;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.ModularScreen;
import com.cleanroommc.modularui.utils.Alignment;
import com.cleanroommc.modularui.widgets.ButtonWidget;
import com.cleanroommc.modularui.widgets.TextWidget;
import com.sysnote8.bquchunks.MainMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.chunk.Chunk;

import java.awt.*;

public class TestGUI {
    public static ModularScreen createGUI() {
        ModularPanel panel = ModularPanel.defaultPanel("tutorial_panel");
        panel.child(new TextWidget(IKey.str("Hello World!")))
                .child(new ButtonWidget<>()
                        .align(Alignment.TopRight)
                        .size(60, 16)
                        .overlay(IKey.str("Hello World!!"))
                        .onMousePressed(button -> {
                            EntityPlayer player = Minecraft.getMinecraft().player;
                            BlockPos playerPos = player.getPosition().down();
                            Chunk chunk = player.world.getChunk(playerPos);
                            int colorValue = chunk.getBlockState(playerPos).getMapColor(player.world, player.getPosition()).colorValue;
                            int r = colorValue >> 16 & 255;
                            int g = colorValue >> 8 & 255;
                            int b = colorValue & 255;
                            int a = 255;
                            player.sendMessage(new TextComponentString("Clicked with "+button+"! Your Chunk: " + chunk.getPos() + " / rgba:(" + r + ", " + g + ", " + b + ", " + a + ")"));
                            MainMod.color = new Color(r,g,b,a);
                            return true;
                        }));
//                .child(new ButtonWidget<>()
//                        .align(Alignment.BottomLeft)
//                        .overlay(UITexture.fullImage(new ResourceLocation(Tags.MODID, "textures/ui/box.png")))
//                        .onMousePressed(button -> {
//                            EntityPlayer player = Minecraft.getMinecraft().player;
//                            player.sendMessage(new TextComponentString("Clicked Texture!! " + player.getName()));
//                            player.sendMessage(new TextComponentString("Your Chunk: " + player.world.getChunk(player.getPosition())));
//                            return true;
//                        }));
        return new ModularScreen(panel);
    }
}
