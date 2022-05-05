package BoosterPacks.actions.defect;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

public class TailRecursivityAction extends AbstractGameAction {

    private final int potency;

    public TailRecursivityAction(int potency) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.potency = potency;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.filledOrbCount() >= 1) {
            AbstractOrb leftOrb = p.orbs.get(p.filledOrbCount() - 1);
            for (int i = 0; i < this.potency; i++) {
                this.addToTop(new ChannelAction(leftOrb.makeCopy()));
            }
        }

        this.isDone = true;
    }
}
