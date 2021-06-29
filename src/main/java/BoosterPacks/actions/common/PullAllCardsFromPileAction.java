package BoosterPacks.actions.common;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class PullAllCardsFromPileAction extends AbstractGameAction {

    private final CardGroup source;
    private final String card;

    public PullAllCardsFromPileAction(CardGroup source, String cardID) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.source = source;
        this.card = cardID;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup hand = p.hand;
        CardGroup discardPile = p.discardPile;
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c: source.group) {
            if (c.cardID.equals(card)) {
                temp.addToTop(c);
            }
        }
        for (AbstractCard c: temp.group) {
            if (hand.group.size() < BaseMod.MAX_HAND_SIZE) {
                hand.addToTop(c);
                c.unfadeOut();
                source.removeCard(c);
            }
        }

        this.isDone = true;
    }
}
