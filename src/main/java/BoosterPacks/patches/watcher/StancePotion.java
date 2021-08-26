package BoosterPacks.patches.watcher;

import BoosterPacks.cards.tempCards.ChooseCourage;
import BoosterPacks.stances.CourageStance;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.optionCards.ChooseCalm;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.helpers.TipHelper;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch(clz = com.megacrit.cardcrawl.potions.StancePotion.class, method = "use")
public class StancePotion {
    @SpireInsertPatch(locator = StancePotion.Locator.class)
    public static void patch(com.megacrit.cardcrawl.potions.StancePotion __instance, AbstractCreature target, ArrayList<AbstractCard> ___stanceChoices) {
        ___stanceChoices.add(new ChooseCourage());
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctBehavior) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(com.megacrit.cardcrawl.potions.StancePotion.class, "addToBot");
            return LineFinder.findInOrder(ctBehavior, finalMatcher);
        }
    }
}
