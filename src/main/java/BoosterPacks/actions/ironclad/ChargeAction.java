package BoosterPacks.actions.ironclad;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;

public class ChargeAction extends AbstractGameAction {

    private final int draw;

    public ChargeAction(int draw) {
        this.duration = 0.0F;
        this.actionType = ActionType.DAMAGE;
        this.draw = draw;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(VigorPower.POWER_ID)) {
            this.addToBot(new DrawCardAction(this.draw));
        }

        this.isDone = true;
    }
}
