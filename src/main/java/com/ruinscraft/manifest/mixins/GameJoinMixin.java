package com.ruinscraft.manifest.mixins;

import com.ruinscraft.manifest.ManifestMod;
import com.ruinscraft.manifest.NetworkUtil;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class GameJoinMixin {

    @Inject(at = @At("RETURN"), method = "onGameJoin")
    private void onGameJoin(GameJoinS2CPacket packet, CallbackInfo info) {
        NetworkUtil.sendModsManifestPacket(ManifestMod.getInstance().getMods());
    }

}
