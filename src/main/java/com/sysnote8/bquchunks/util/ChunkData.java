package com.sysnote8.bquchunks.util;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ChunkData {
    public static final String TAG_CHUNK_X = "chunk_x";
    public static final String TAG_CHUNK_Z = "chunk_z";
    public static final String TAG_DIM = "dim";
    private final int x;
    private final int z;
    private final int dimId;
    public ChunkData(int x, int z, int dimId) {
        this.x = x;
        this.z = z;
        this.dimId = dimId;
    }

    public int x() {
        return x;
    }

    public int z() {
        return z;
    }

    public int dimId() {
        return dimId;
    }

    @NotNull
    public NBTTagCompound toNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger(TAG_CHUNK_X, x);
        compound.setInteger(TAG_CHUNK_Z, z);
        compound.setInteger(TAG_DIM, dimId);
        return compound;
    }

    public static Optional<ChunkData> fromNBT(@NotNull NBTTagCompound compound) {
        if(!compound.hasKey(TAG_CHUNK_X) || !compound.hasKey(TAG_CHUNK_Z) || !compound.hasKey(TAG_DIM)) return Optional.empty();
        return Optional.of(new ChunkData(compound.getInteger(TAG_CHUNK_X), compound.getInteger(TAG_CHUNK_Z), compound.getInteger(TAG_DIM)));
    }

    @NotNull
    public static ChunkData fromChunk(@NotNull Chunk chunk) {
        return new ChunkData(chunk.x, chunk.z, chunk.getWorld().provider.getDimension());
    }
}
