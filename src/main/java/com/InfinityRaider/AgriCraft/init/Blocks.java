package com.InfinityRaider.AgriCraft.init;

import com.InfinityRaider.AgriCraft.blocks.*;
import com.InfinityRaider.AgriCraft.compatibility.ModIntegration;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import com.InfinityRaider.AgriCraft.items.ItemBlockCustomWood;
import com.InfinityRaider.AgriCraft.reference.Names;
import com.InfinityRaider.AgriCraft.reference.Reference;
import com.InfinityRaider.AgriCraft.utility.LogHelper;
import com.InfinityRaider.AgriCraft.utility.RegisterHelper;
import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class Blocks {
    public static BlockCrop blockCrop;
    public static BlockSeedAnalyzer seedAnalyzer;
    public static BlockWaterTank blockWaterTank;
    public static BlockWaterChannel blockWaterChannel;
    public static BlockChannelValve blockChannelValve;
    public static BlockSprinkler blockSprinkler;
    public static BlockSeedStorage blockSeedStorage;

    public static void init() {
        blockCrop = getBlockCrop();
        RegisterHelper.registerBlock(blockCrop, Names.Objects.crops);
        seedAnalyzer = new BlockSeedAnalyzer();
        RegisterHelper.registerBlock(seedAnalyzer, Names.Objects.seedAnalyzer);
        if(ConfigurationHandler.enableSeedStorage) {
            // blockSeedStorage = new BlockSeedStorage();
            // RegisterHelper.registerBlock(blockSeedStorage, Names.Objects.seedStorage, ItemBlockCustomWood.class);
        }
        if(!ConfigurationHandler.disableIrrigation) {
            blockWaterTank = new BlockWaterTank();
            RegisterHelper.registerBlock(blockWaterTank, Names.Objects.tank, ItemBlockCustomWood.class);
            blockWaterChannel = new BlockWaterChannel();
            RegisterHelper.registerBlock(blockWaterChannel, Names.Objects.channel, ItemBlockCustomWood.class);
            blockChannelValve = new BlockChannelValve();
            RegisterHelper.registerBlock(blockChannelValve, Names.Objects.valve, ItemBlockCustomWood.class);
            blockSprinkler = new BlockSprinkler();
            RegisterHelper.registerBlock(blockSprinkler, Names.Objects.sprinkler);
        }
        LogHelper.info("Blocks registered");
    }

    private static BlockCrop getBlockCrop() {
        if (ModIntegration.LoadedMods.botania) {
            try {
                Class<BlockCrop> clazz = (Class<BlockCrop>) Class.forName("com.InfinityRaider.AgriCraft.blocks.BlockCropBotania");
                return clazz.newInstance();
            } catch (Exception e) {
                FMLLog.log(Reference.MOD_ID, Level.ERROR, e, "Unable to create BlockCropBotania instance.");
            }
        }

        return new BlockCrop();
    }
}
