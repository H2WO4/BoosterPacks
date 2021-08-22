package BoosterPacks.patches.defect;

import BoosterPacks.powers.defect.IntegrityPower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Plasma;

@SpirePatch(clz = AbstractOrb.class, method = "applyFocus")
public class OrbFocus {
    public static void Postfix(AbstractOrb __instance) {
        if (!__instance.ID.equals(Plasma.ORB_ID)) {
            AbstractPlayer p = AbstractDungeon.player;
            __instance.evokeAmount += (p.hasPower(IntegrityPower.POWER_ID) ? p.getPower(IntegrityPower.POWER_ID).amount : 0);
        }
    }
}