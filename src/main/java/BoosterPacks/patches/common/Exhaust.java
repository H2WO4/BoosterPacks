package BoosterPacks.patches.common;

import BoosterPacks.actions.common.PullAllCardsFromPileAction;
import BoosterPacks.cards.red.AshesToAshes;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = CardGroup.class, method = "moveToExhaustPile")
public class Exhaust {
    public static void Postfix(CardGroup __instance, AbstractCard c) {
        if (AbstractDungeon.player.masterDeck.contains(new AshesToAshes())) {
            AbstractDungeon.actionManager.addToBottom(new PullAllCardsFromPileAction(AbstractDungeon.player.discardPile, AshesToAshes.ID));
        }
    }
}