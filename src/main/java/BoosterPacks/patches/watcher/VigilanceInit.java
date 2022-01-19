package BoosterPacks.patches.watcher;

import BoosterPacks.BoosterPacks;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.purple.Vigilance;
import com.megacrit.cardcrawl.core.CardCrawlGame;

@SpirePatch(clz = Vigilance.class, method = SpirePatch.CONSTRUCTOR)
public class VigilanceInit {
    public static void Postfix(Vigilance __instance) {
        __instance.rawDescription = CardCrawlGame.languagePack.getCardStrings(BoosterPacks.getModID() + ":" + Vigilance.ID).DESCRIPTION;
    }
}
