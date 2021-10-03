package BoosterPacks.actions.ironclad;

import BoosterPacks.cards.red.MobMentality;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
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
        for (AbstractCard c: p.drawPile.group) {
            if (c.cardID.equals(MobMentality.ID) && p.hand.size() + i < BaseMod.MAX_HAND_SIZE) {
                p.drawPile.removeCard(c);
                p.hand.addToHand(c);
                i++;
            }
        }

        this.isDone = true;
    }
}
