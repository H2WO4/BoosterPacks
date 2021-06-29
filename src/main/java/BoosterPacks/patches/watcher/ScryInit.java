package BoosterPacks.patches.watcher;

import BoosterPacks.powers.watcher.OraclePower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = ScryAction.class, method = SpirePatch.CONSTRUCTOR)
public class ScryInit {
    public static void Postfix(ScryAction __instance) {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(OraclePower.POWER_ID)) {
            p.getPower(OraclePower.POWER_ID).flash();
            int visions = p.getPower(OraclePower.POWER_ID).amount;
            __instance.amount += visions;
        }
    }
}