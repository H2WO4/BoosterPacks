package BoosterPacks.actions.defect;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixInversionAction extends AbstractGameAction {

    public MatrixInversionAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractOrb> orbList = new ArrayList<>();
        for (AbstractOrb o: p.orbs) {
            if (!(o instanceof EmptyOrbSlot)) {
                orbList.add(o);
            }
        }
        Collections.reverse(orbList);
        int i = 0;
        for (AbstractOrb o: orbList) {
            p.orbs.set(i, o);
            o.setSlot(i, p.maxOrbs);
            i++;
        }

        this.isDone = true;
    }
}
