package BoosterPacks.actions.defect;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

public class TriggerAllOrbsAction extends AbstractGameAction {

    private final String orbType;

    public TriggerAllOrbsAction(String orbType) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.orbType = orbType;
    }

    public TriggerAllOrbsAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.orbType = "ALL";
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractOrb o: p.orbs) {
            if (!(o instanceof EmptyOrbSlot) && (o.ID.equals(orbType) || (orbType.equals("ALL")))) {
                o.onEndOfTurn();
                o.onStartOfTurn();
            }
        }

        this.isDone = true;
    }
}
