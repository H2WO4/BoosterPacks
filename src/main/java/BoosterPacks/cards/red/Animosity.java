package BoosterPacks.cards.red;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Animosity extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Animosity.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Animosity.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.RED;
    private static final int COST = 1;

    public Animosity() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = 5;
        this.damage = this.baseDamage;
        this.baseMagicNumber = 2;
        this.magicNumber = baseMagicNumber;
    }

    @Override
    public void applyPowers() {
        AbstractPlayer p = AbstractDungeon.player;
        int debuffs = 0;
        for (AbstractPower po: p.powers) {
            if (po.type == AbstractPower.PowerType.DEBUFF || po.amount < 0) {
                debuffs += Math.abs(po.amount);
            }
        }
        int realBaseDamage = this.baseDamage;
        this.baseDamage += this.magicNumber * debuffs;
        super.applyPowers();
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPlayer p = AbstractDungeon.player;
        int debuffs = 0;
        for (AbstractPower po: p.powers) {
            if (po.type == AbstractPower.PowerType.DEBUFF || po.amount < 0) {
                debuffs += Math.abs(po.amount);
            }
        }
        for (AbstractPower po: mo.powers) {
            if (po.type == AbstractPower.PowerType.DEBUFF || po.amount < 0) {
                debuffs += Math.abs(po.amount);
            }
        }
        int realBaseDamage = this.baseDamage;
        this.baseDamage += this.magicNumber * debuffs;
        super.calculateCardDamage(mo);
        this.baseDamage = realBaseDamage;
        this.isDamageModified = this.damage != this.baseDamage;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);
            initializeDescription();
        }
    }
}
