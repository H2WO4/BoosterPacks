package BoosterPacks.patches.common;

import BoosterPacks.actions.common.PullAllCardsFromPileAction;
import BoosterPacks.cards.curses.Guilt;
import BoosterPacks.cards.red.StrikeBarrage;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = ShuffleAction.class, method = "update")
@SpirePatch(clz = EmptyDeckShuffleAction.class, method = "update")
@SpirePatch(clz = ShuffleAllAction.class, method = "update")
public class Shuffle {
    public static void Postfix(AbstractGameAction __instance) {
        AbstractDungeon.actionManager.addToBottom(new PullAllCardsFromPileAction(AbstractDungeon.player.exhaustPile, StrikeBarrage.ID));
        AbstractDungeon.actionManager.addToBottom(new PullAllCardsFromPileAction(AbstractDungeon.player.drawPile, Guilt.ID));
    }
}