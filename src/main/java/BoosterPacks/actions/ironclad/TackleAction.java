package BoosterPacks.actions.ironclad;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class TackleAction extends AbstractGameAction {

    private final int energy;

    public TackleAction(int energy) {
        this.duration = 0.0F;
        this.actionType = ActionType.DAMAGE;
        this.energy = energy;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractCard> cardsPlayed = AbstractDungeon.actionManager.cardsPlayedThisCombat;
        if (!(cardsPlayed.size() >= 2) && cardsPlayed.get(cardsPlayed.size() - 2).cost >= 2) {
            this.addToBot(new GainEnergyAction(this.energy));
        }

        this.isDone = true;
    }
}
