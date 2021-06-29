package BoosterPacks.actions.watcher;

import BoosterPacks.stances.CourageStance;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class AudacityAction extends AbstractGameAction {

    public AudacityAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
    }

    public void update() {
        for (AbstractCard c : DrawCardAction.drawnCards) {
            if (c.type == CardType.SKILL) {
                AbstractDungeon.actionManager.addToBottom(new ChangeStanceAction(new CourageStance()));
                break;
            }
        }

        this.isDone = true;
    }
}
