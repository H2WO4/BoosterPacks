package BoosterPacks.patches.watcher;

import BoosterPacks.cards.purple.FreeWill;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.purple.Vigilance;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch(clz = Vigilance.class, method = SpirePatch.CONSTRUCTOR)
public class VigilanceInit {
    public static void Postfix(Vigilance __instance) {
        __instance.rawDescription = CardCrawlGame.languagePack.getCardStrings(BoosterPacks.getModID + ":" + Vigilance.ID).DESCRIPTION;
    }
}
