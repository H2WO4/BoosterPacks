package BoosterPacks.patches.silent;

import BoosterPacks.powers.silent.NinjutsuPower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = com.megacrit.cardcrawl.cards.tempCards.Shiv.class, method = SpirePatch.CONSTRUCTOR)
public class ShivInit {
    public static void Postfix(com.megacrit.cardcrawl.cards.tempCards.Shiv __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p != null && p.hasPower(NinjutsuPower.POWER_ID)) {
            __instance.selfRetain = true;
            __instance.rawDescription = "Retain. NL " + __instance.rawDescription;
        }
    }
}