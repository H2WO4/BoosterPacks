package BoosterPacks.actions.ironclad;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class WorseningAction extends AbstractGameAction {

    public WorseningAction(AbstractPlayer p, AbstractMonster m) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;

        this.source = p;
        this.target = m;
    }

    public void update() {
        for (AbstractPower po: this.target.powers) {
            if (po.type == AbstractPower.PowerType.DEBUFF && po.amount > 0) {
                this.addToBot(new ApplyPowerAction(this.target, this.source, po));
            }
        }

        this.isDone = true;
    }
}
