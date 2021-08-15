package BoosterPacks.actions.defect;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class InvokeAction extends AbstractGameAction {

    public AbstractOrb orb;

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
