package BoosterPacks.patches.watcher;

import BoosterPacks.powers.watcher.EncorePower;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

@SpirePatch(clz = PressEndTurnButtonAction.class, method = "update")
public class ForcedEndTurn {
    public static SpireReturn<Void> Prefix(AbstractGameAction __instance){
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(EncorePower.POWER_ID)) {
            AbstractPower encore = p.getPower(EncorePower.POWER_ID);
            encore.flash();
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(encore.amount));
            AbstractDungeon.actionManager.addToBottom(new DiscardAction(p, p, encore.amount * 2, false, false));
            __instance.isDone = true;
            return SpireReturn.Return(null);
        }

        return SpireReturn.Continue();
    }
}