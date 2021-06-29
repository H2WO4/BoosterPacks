package BoosterPacks.actions.silent;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class PerfectionistCostAction extends AbstractGameAction {

    private final AbstractCard card;

    public PerfectionistCostAction(AbstractCard c) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.card = c;
    }

    public void update() {
        card.costForTurn = BaseMod.MAX_HAND_SIZE - AbstractDungeon.player.hand.size();

        this.isDone = true;
    }
}
