package BoosterPacks.patches.defect;

import BoosterPacks.powers.defect.IntegrityPower;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;

@SpirePatch(clz = Dark.class, method = SpirePatch.CONSTRUCTOR)
public class DarkOrbConstructor {
    public static void Postfix(Dark __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(IntegrityPower.POWER_ID)) {
            int evoke = ReflectionHacks.getPrivate(__instance, AbstractOrb.class, "evokeAmount");
            ReflectionHacks.setPrivate(__instance, AbstractOrb.class, "evokeAmount", evoke + p.getPower(IntegrityPower.POWER_ID).amount);
        }
    }
}