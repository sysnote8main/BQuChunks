package com.sysnote8.bquchunks;

import com.cleanroommc.modularui.factory.ClientGUI;
import com.sysnote8.bquchunks.gui.TestGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.awt.*;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:betterquesting"
)
@Mod.EventBusSubscriber
public class MainMod {

    public static Color color = new Color(200);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
        if(!event.getEntityPlayer().getEntityWorld().isRemote && event.getItemStack().getItem() == Items.STICK) {
            ClientGUI.open(TestGUI.createGUI());
        }
    }

//    public static Pair<BlockPos, BlockPos> calcChunkCorner(int chunkX, int chunkZ) {
//        int Ax = chunkX * 16 + (chunkX < 0 ? 1 : -1);
//        int Az = chunkZ * 16 + (chunkZ < 0 ? 1 : -1);
//        int Bx = (chunkX + (chunkX < 0 ? -1 : 1)) * 16;
//        int Bz = (chunkZ + (chunkZ < 0 ? -1 : 1)) * 16;
//        return Pair.of(new BlockPos(Ax, 0, Az), new BlockPos(Bx, 0, Bz));
//    }
//
//    @SubscribeEvent
//    public void render(TickEvent.RenderTickEvent event) {
//        if(Minecraft.getMinecraft().world == null) return;
//        if(!Minecraft.getMinecraft().world.isRemote) return;
//        if(Minecraft.getMinecraft().fontRenderer == null) return;
//        Minecraft mc = Minecraft.getMinecraft();
//        Chunk chunk = mc.world.getChunk(mc.player.getPosition());
//        Pair<BlockPos, BlockPos> blockPosPair = calcChunkCorner(chunk.x, chunk.z);
//        mc.fontRenderer.drawStringWithShadow("Hello World!", 20, 20, color.getRGB());
//        if(mc.currentScreen == null) return;
//        mc.ingameGUI.drawString(mc.ingameGUI.getFontRenderer(), "Welcome to sevtech age age!", 20, 40, 0);
//        mc.fontRenderer.drawStringWithShadow("Chunk: [" + (chunk.x * 16 - 1) + ", " + (chunk.z * 16 - 1) + "]", 5, mc.currentScreen.height - mc.fontRenderer.FONT_HEIGHT, 0);
//    }
}
