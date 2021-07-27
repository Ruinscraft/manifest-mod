package com.ruinscraft.manifest;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.Map;

public final class NetworkUtil {

    private static final Identifier CHANNEL_MODS_MANIFEST = new Identifier("manifest", "mods_manifest");

    public static void sendModsManifestPacket(Map<String, String> mods) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(CHANNEL_MODS_MANIFEST, buf);
    }

}
