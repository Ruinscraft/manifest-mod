package com.ruinscraft.manifest;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.Map;

public final class NetworkUtil {

    private static final Identifier CHANNEL_MODS_MANIFEST = new Identifier("manifest", "mods_manifest");

    public static void sendModsManifestPacket(Map<String, String> mods) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeInt(mods.size());
        for (String modName : mods.keySet()) {
            out.writeUTF(modName); // write name
            out.writeUTF(mods.get(modName)); // write version
        }
        PacketByteBuf byteBuf = new PacketByteBuf(Unpooled.buffer());
        byteBuf.writeBytes(out.toByteArray());
        ClientPlayNetworking.send(CHANNEL_MODS_MANIFEST, byteBuf);
    }

}
