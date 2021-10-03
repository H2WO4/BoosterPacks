package BoosterPacks.actions.silent;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class AssassinateAction extends AbstractGameAction {

    private final AbstractCard card;

    public AssassinateAction(AbstractCard c) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.card = c;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        p.discardPile.removeCard(card);
        p.hand.addToHand(card);

        this.isDone = true;
    }
}
