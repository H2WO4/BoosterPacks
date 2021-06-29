package BoosterPacks.actions.silent;

import BoosterPacks.actions.common.MoveToHandAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class MasterTrickAction extends AbstractGameAction {

    private final AbstractCard card;

    public MasterTrickAction(AbstractCard c) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.card = c;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup draw = p.drawPile;
        CardGroup discard = p.discardPile;

        if (draw.contains(card)) {
            this.addToBot(new MoveToHandAction(card, draw));
        }
        else if (discard.contains(card)) {
            this.addToBot(new MoveToHandAction(card, discard));
        }


        this.isDone = true;
    }
}
