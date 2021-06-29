package BoosterPacks.actions.watcher;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class FriendshipAction extends AbstractGameAction {

    public FriendshipAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractCard> hand = p.hand.group;
        for (AbstractCard c: hand) {
            c.retain = true;
        }

        this.isDone = true;
    }
}
