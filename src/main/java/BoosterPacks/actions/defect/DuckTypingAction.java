package BoosterPacks.actions.defect;

import com.evacipated.cardcrawl.mod.stslib.actions.defect.EvokeSpecificOrbAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

import java.util.ArrayList;

public class DuckTypingAction extends AbstractGameAction {

    public DuckTypingAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (!p.orbs.isEmpty()) {
            AbstractOrb firstOrb = p.orbs.get(0);
            ArrayList<Integer> toEvoke = new ArrayList<>();
            int i = 0;
            for (AbstractOrb o: p.orbs) {
                if (!(o instanceof EmptyOrbSlot) && o.ID.equals(firstOrb.ID)) {
                    toEvoke.add(i);
                }
                i++;
            }
            int negIndex = 0;
            for (int o: toEvoke) {
                this.addToBot(new EvokeSpecificOrbAction(p.orbs.get(o-negIndex)));
                this.addToBot(new DrawCardAction(1));
            }
        }

        this.isDone = true;
    }
}
