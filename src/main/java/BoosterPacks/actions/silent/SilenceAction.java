package BoosterPacks.actions.silent;

import BoosterPacks.cards.green.MasterTrick;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SilenceAction extends AbstractGameAction {


    private final int block;

    public SilenceAction(int block) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.block = block;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        int n = p.hand.group.size();
        this.addToBot(new DiscardAction(p, p, 99, false));

        for (int i = 0; i < n; i++) {
            this.addToBot(new GainBlockAction(p, p, this.block));
        }

        this.isDone = true;
    }
}
