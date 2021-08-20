package BoosterPacks.patches.watcher;

import BoosterPacks.cards.purple.FreeWill;
import BoosterPacks.powers.watcher.ThreadsOfFatePower;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch(clz = ScryAction.class, method = "update")
public class Scry {
    @SpireInsertPatch(locator = Locator.class)
    public static void patch(ScryAction __instance) {
        ArrayList<AbstractCard> cardsDiscarded = AbstractDungeon.gridSelectScreen.selectedCards;
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractCard c: cardsDiscarded) {
            if (p.hasPower(ThreadsOfFatePower.POWER_ID)) {
                ThreadsOfFatePower power = (ThreadsOfFatePower) p.getPower(ThreadsOfFatePower.POWER_ID);
                power.onDiscardScry();
            }
            c.triggerOnManualDiscard();
        }
        if (p.cardInUse != null && p.cardInUse.cardID.equals(FreeWill.ID)) {
            FreeWill.drawForDiscard(cardsDiscarded.size());
        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctBehavior) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(ArrayList.class, "clear");
            return LineFinder.findInOrder(ctBehavior, finalMatcher);
        }
    }
}
