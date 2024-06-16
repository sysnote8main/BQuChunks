package com.sysnote8.bquchunks.claim;

import com.sysnote8.bquchunks.structure.claim.IClaimManager;
import com.sysnote8.bquchunks.util.ChunkData;

import java.util.List;

public class ClaimManager implements IClaimManager {
    @Override
    public boolean addClaim(ChunkData chunkData, int partyId) {
        return false;
    }

    @Override
    public boolean getClaim(ChunkData chunkData) {
        return false;
    }

    @Override
    public boolean updateClaim(ChunkData chunkData, int newOwnerPartyId) {
        return false;
    }

    @Override
    public boolean removeClaim(ChunkData chunkData) {
        return false;
    }

    @Override
    public List<ChunkData> getClaims(int partyId) {
        return null;
    }

    @Override
    public boolean removePartyClaim(int partyId) {
        return false;
    }
}
