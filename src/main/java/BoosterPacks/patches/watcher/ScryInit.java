package BoosterPacks.patches.watcher;

import BoosterPacks.powers.watcher.OraclePower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

@SpirePatch(clz = ScryAction.class, method = SpirePatch.CONSTRUCTOR)
public class ScryInit {
    public static void Postfix(ScryAction __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(OraclePower.POWER_ID)) {
            AbstractPower oracle = p.getPower(OraclePower.POWER_ID);
            oracle.flash();
            __instance.amount += oracle.amount;
        }
    }
}