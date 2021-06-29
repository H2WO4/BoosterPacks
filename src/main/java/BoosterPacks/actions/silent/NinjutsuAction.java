package BoosterPacks.actions.silent;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class NinjutsuAction extends AbstractGameAction {

    public NinjutsuAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;

        for (AbstractCard c: p.hand.group) {
            if (c.cardID.equals(Shiv.ID)) {
                c.selfRetain = true;
                c.rawDescription = "Retain. NL " + c.rawDescription;
                c.initializeDescription();
            }
        }
        for (AbstractCard c: p.drawPile.group) {
            if (c.cardID.equals(Shiv.ID)) {
                c.selfRetain = true;
                c.rawDescription = "Retain. NL " + c.rawDescription;
                c.initializeDescription();
            }
        }
        for (AbstractCard c: p.discardPile.group) {
            if (c.cardID.equals(Shiv.ID)) {
                c.selfRetain = true;
                c.rawDescription = "Retain. NL " + c.rawDescription;
                c.initializeDescription();
            }
        }
        for (AbstractCard c: p.exhaustPile.group) {
            if (c.cardID.equals(Shiv.ID)) {
                c.selfRetain = true;
                c.rawDescription = "Retain. NL " + c.rawDescription;
                c.initializeDescription();
            }
        }

        this.isDone = true;
    }
}
