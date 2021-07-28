package com.ruinscraft.manifest;

import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

        findSteveCinemaMods();

        for (String mod : mods.keySet()) {
            System.out.println(mod + " " + mods.get(mod));
        }
    }

    private void findSteveCinemaMods() {
        File steveCinemaModsDir = new File("mods/stevecinema.com");

        if (steveCinemaModsDir.exists()) {
            for (String fileName : steveCinemaModsDir.list()) {
                File file = new File(steveCinemaModsDir, fileName);
                try {
                    String SHA1 = HashUtil.SHA1(file);
                    mods.put(fileName, SHA1);
                } catch (IOException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
