package com.sysnote8.bquchunks.api.util;

import com.sysnote8.bquchunks.Tags;
import net.minecraftforge.fml.common.Loader;
import org.jetbrains.annotations.NotNull;

public enum Mods {
    BetterQuestingUnofficial("betterquesting"),
    BQuChunks(Tags.MODID);
    private final String modid;
    private Boolean isLoaded;
    Mods(String modid) {
        this.modid = modid;
    }

    @NotNull
    public String getId() {
        return modid;
    }

    public boolean isModLoaded() {
        if(isLoaded == null) isLoaded = Loader.isModLoaded(modid);
        return isLoaded;
    }
}
