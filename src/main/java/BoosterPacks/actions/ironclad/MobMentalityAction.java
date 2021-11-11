package BoosterPacks.actions.ironclad;

import BoosterPacks.cards.red.MobMentality;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class MobMentalityAction extends AbstractGameAction {

    public MobMentalityAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        int i = 0;
        CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c : p.drawPile.group) {
            if (c.cardID.equals(MobMentality.ID)) {
                tmp.addToTop(c);
                i++;
            }
        }
        for (AbstractCard c: tmp.group) {
            if (p.hand.size() + i < BaseMod.MAX_HAND_SIZE) {
                p.drawPile.removeCard(c);
                p.hand.addToHand(c);
                i++;
            }
            else {
                p.createHandIsFullDialog();
                break;
            }
        }

        this.isDone = true;
    }
}
