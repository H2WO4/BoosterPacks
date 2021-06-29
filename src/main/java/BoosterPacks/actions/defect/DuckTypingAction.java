package BoosterPacks.actions.defect;

import com.evacipated.cardcrawl.mod.stslib.actions.defect.EvokeSpecificOrbAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

import java.util.ArrayList;
import java.util.Collections;

public class DuckTypingAction extends AbstractGameAction {

    public DuckTypingAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (!p.orbs.isEmpty()) {
            AbstractOrb firstOrb = p.orbs.get(0);
            ArrayList<AbstractOrb> toEvoke = new ArrayList<>();
            for (AbstractOrb o: p.orbs) {
                if (!(o instanceof EmptyOrbSlot) && o.ID.equals(firstOrb.ID)) {
                    toEvoke.add(o);
                }
            }
            Collections.reverse(toEvoke);
            for (AbstractOrb o: toEvoke) {
                this.addToBot(new EvokeSpecificOrbAction(o));
                this.addToBot(new DrawCardAction(1));
            }
        }

        this.isDone = true;
    }
}
