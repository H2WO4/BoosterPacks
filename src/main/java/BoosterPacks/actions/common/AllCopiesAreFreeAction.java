package BoosterPacks.actions.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class AllCopiesAreFreeAction extends AbstractGameAction {

    private final String card;

    public AllCopiesAreFreeAction(String cardID) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.card = cardID;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractCard c: p.hand.group) {
            if (c.cardID.equals(this.card)) {
                c.setCostForTurn(0);
            }
        }

        this.isDone = true;
    }
}
