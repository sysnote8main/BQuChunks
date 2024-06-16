package com.sysnote8.bquchunks.structure.claim;

import com.sysnote8.bquchunks.util.ChunkData;

import java.util.List;

public interface IClaimManager {
    /**
     * @param chunkData ChunkData of target chunk
     * @param partyId   New claim owner party's id
     * @return Returns result which this action was successful.
     */
    boolean addClaim(ChunkData chunkData, int partyId);

    /**
     * @param chunkData ChunkData of target chunk
     * @return Returns result which this action was successful.
     */
    boolean getClaim(ChunkData chunkData); // TODO return value change to ClaimInfo(copy)

    /**
     * @param chunkData       ChunkData of target chunk
     * @param newOwnerPartyId New owner party's id
     * @return Returns result which this action was successful.
     */
    boolean updateClaim(ChunkData chunkData, int newOwnerPartyId); // TODO int parameter change to ClaimInfo

    /**
     * @param chunkData ChunkData of target chunk
     * @return Returns result which this action was successful.
     */
    boolean removeClaim(ChunkData chunkData);

    /**
     * @param partyId target party's id
     * @return List of target party's all claimed chunk
     */
    List<ChunkData> getClaims(int partyId);

    /**
     * Remove all target party claims.
     *
     * @param partyId Target party's id
     * @return Returns result which this action was successful.
     */
    boolean removePartyClaim(int partyId);
}
