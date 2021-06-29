package BoosterPacks.actions.ironclad;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GambitAction extends AbstractGameAction {

    public GambitAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractCard c: p.hand.group) {
            if (c.type == AbstractCard.CardType.ATTACK) {
                if (c.cost >= 1) {
                    c.setCostForTurn(c.costForTurn - 1);
                }
            }
        }

        this.isDone = true;
    }
}
