package BoosterPacks.actions.silent;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SwissKnifeAction extends AbstractGameAction {

    public SwissKnifeAction(int magicNumber) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.amount = magicNumber;
    }

    public void update() {
        int damage = this.amount * AbstractDungeon.player.hand.group.size();

        this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(damage, true), DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.SLASH_HEAVY, true));

        this.isDone = true;
    }
}
