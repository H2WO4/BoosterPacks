package BoosterPacks.actions.silent;

import BoosterPacks.cards.green.MasterTrick;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class MasterTrickAction extends AbstractGameAction {

    private final boolean upgraded;

    public MasterTrickAction(boolean upgraded) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.upgraded = upgraded;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup draw = p.drawPile;
        CardGroup discard = p.discardPile;

        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c: draw.group) {
            if (!c.cardID.equals(MasterTrick.ID)) {
                temp.addToTop(c);
            }
        }
        if (this.upgraded) {
            for (AbstractCard c: discard.group) {
                if (!c.cardID.equals(MasterTrick.ID)) {
                    temp.addToTop(c);
                }
            }
        }
        temp.sortByRarity(false);
        this.addToBot(new SelectCardsAction(temp.group, 1, "Choose a card", (cards) -> {
            AbstractCard card = cards.get(0);
            AbstractDungeon.actionManager.addToTop(new MasterTrickMoveAction(card));
        }));


        this.isDone = true;
    }
}
