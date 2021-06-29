package BoosterPacks.patches.silent;

import BoosterPacks.powers.silent.ShinigamiPower;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.MinionPower;
import javassist.CtBehavior;

@SpirePatch(clz = PoisonLoseHpAction.class, method = "update")
public class PoisonKill {

    @SpireInsertPatch(locator = PoisonKill.Locator.class)
    public static void patch(PoisonLoseHpAction __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        if (!__instance.target.hasPower(MinionPower.POWER_ID) && p.hasPower(ShinigamiPower.POWER_ID)) {
            p.getPower(ShinigamiPower.POWER_ID).flash();
            AbstractDungeon.actionManager.addToTop(new HealAction(p, p, p.getPower(ShinigamiPower.POWER_ID).amount));
        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctBehavior) throws Exception {
            Matcher finalMatcher = new Matcher.FieldAccessMatcher(AbstractPlayer.class, "poisonKillCount");
            return LineFinder.findInOrder(ctBehavior, finalMatcher);
        }
    }
}
