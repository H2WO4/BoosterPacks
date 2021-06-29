package BoosterPacks.patches.defect;

import BoosterPacks.powers.defect.DarkFocusPower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Dark;

@SpirePatch(clz = Dark.class, method = "applyFocus")
public class DarkOrbFocus {
    public static void Postfix(Dark __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        __instance.passiveAmount += (p.hasPower(DarkFocusPower.POWER_ID) ? p.getPower(DarkFocusPower.POWER_ID).amount: 0);
    }
}