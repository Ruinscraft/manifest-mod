package com.ruinscraft.manifest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.util.HashMap;
import java.util.Map;

public class ManifestMod implements ModInitializer {

    private static ManifestMod instance;

    public static ManifestMod getInstance() {
        return instance;
    }

    private Map<String, String> mods;

    public Map<String, String> getMods() {
        return mods;
    }

    @Override
    public void onInitialize() {
        instance = this;

        mods = new HashMap<>();

        for (ModContainer modContainer : FabricLoader.getInstance().getAllMods()) {
            mods.put(modContainer.getMetadata().getName(), modContainer.getMetadata().getVersion().getFriendlyString());
        }
    }

}
