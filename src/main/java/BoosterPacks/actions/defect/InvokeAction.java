package BoosterPacks.actions.defect;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

public class InvokeAction extends AbstractGameAction {

    private AbstractOrb orb;

    public InvokeAction(AbstractOrb orb) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.orb = orb;
    }

    public void update() {
        orb.onEvoke();

        this.isDone = true;
    }
}
