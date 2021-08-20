package BoosterPacks.patches.defect;

import BoosterPacks.relics.defect.BlackLED;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;

@SpirePatch(clz = Dark.class, method = SpirePatch.CONSTRUCTOR)
public class DarkOrbConstructor {
    public static void Postfix(Dark __instance) {
        if (AbstractDungeon.player.hasRelic(BlackLED.ID)) {
            ReflectionHacks.setPrivate(__instance, AbstractOrb.class, "baseEvokeAmount", 12);
            ReflectionHacks.setPrivate(__instance, AbstractOrb.class, "evokeAmount", 12);
        }
    }
}