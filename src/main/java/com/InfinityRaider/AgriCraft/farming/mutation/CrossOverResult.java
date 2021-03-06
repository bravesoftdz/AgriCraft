package com.InfinityRaider.AgriCraft.farming.mutation;

import com.InfinityRaider.AgriCraft.tileentity.TileEntityCrop;
import com.InfinityRaider.AgriCraft.utility.SeedHelper;
import net.minecraft.item.ItemSeeds;

/**
 * Represents the result of a specific <code>INewSeedStrategy</code> containing
 * the seed plus meta and the chance to happen.
 */
public class CrossOverResult {

    private final ItemSeeds seed;
    private final int meta;
    private final double chance;

    private int growth;
    private int gain;
    private int strength;

    public CrossOverResult(ItemSeeds seed, int meta, double chance) {
        this.seed = seed;
        this.meta = meta;
        this.chance = chance;
    }

    /** Creates a new instance based on the planted seed of the given TE. Does not validate the TE */
    public static CrossOverResult fromTileEntityCrop(TileEntityCrop crop) {
        ItemSeeds seed = (ItemSeeds) crop.seed;
        int meta = crop.seedMeta;
        double chance = SeedHelper.getSpreadChance(seed, meta);

        return new CrossOverResult(seed, meta, chance);
    }

    /** Creates a new instanced based off the result of the given mutation. Does not validate the mutation object */
    public static CrossOverResult fromMutation(Mutation mutation) {
        ItemSeeds seed = (ItemSeeds) mutation.result.getItem();
        int meta = mutation.result.getItemDamage();

        return new CrossOverResult(seed, meta, mutation.chance);
    }

    public ItemSeeds getSeed() {
        return seed;
    }

    public int getMeta() {
        return meta;
    }

    public double getChance() {
        return chance;
    }

    public int getGain() {
        return gain;
    }

    public int getGrowth() {
        return growth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStats(int growth, int gain, int strength) {
        this.growth = growth;
        this.gain = gain;
        this.strength = strength;
    }
}
