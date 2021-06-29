package BoosterPacks.actions.common;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class FillHandAction extends AbstractGameAction {

    private final AbstractCard card;
    private final int upTo;

    public FillHandAction(AbstractCard card) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.card = card;
        this.upTo = BaseMod.MAX_HAND_SIZE;
    }

    public FillHandAction(AbstractCard card, int upTo) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.card = card;
        this.upTo = upTo;
    }

    public void update() {
        int numberCards = this.upTo - AbstractDungeon.player.hand.size();
        if (numberCards > 0) {
            this.addToBot(new MakeTempCardInHandAction(card, numberCards));
        }

        this.isDone = true;
    }
}
