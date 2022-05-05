package BoosterPacks.patches.watcher;

import BoosterPacks.BoosterPacks;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.purple.Vigilance;
import com.megacrit.cardcrawl.core.CardCrawlGame;

@SpirePatch(clz = Vigilance.class, method = SpirePatch.STATICINITIALIZER)
public class VigilanceInit {
    public static void Postfix() {
        ReflectionHacks.setPrivateStaticFinal(Vigilance.class, "cardStrings", CardCrawlGame.languagePack
                        .getCardStrings(BoosterPacks.getModID() + ":" + Vigilance.ID));
    }
}
