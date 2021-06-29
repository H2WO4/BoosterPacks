package BoosterPacks.actions.system;

import BoosterPacks.patches.BoosterTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class LatentAction extends AbstractGameAction {

    public LatentAction() {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup draw = p.drawPile;
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c: draw.group) {
            if (c.hasTag(BoosterTags.LATENT)) {
                temp.addToTop(c);
            }
        }
        for (AbstractCard c: temp.group) {
            draw.moveToBottomOfDeck(c);
        }

        this.isDone = true;
    }
}
