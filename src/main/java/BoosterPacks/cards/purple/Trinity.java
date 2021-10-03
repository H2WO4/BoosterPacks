package BoosterPacks.cards.purple;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.DivinityStance;
import com.megacrit.cardcrawl.stances.NeutralStance;
import com.megacrit.cardcrawl.vfx.combat.EmptyStanceEffect;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Trinity extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Trinity.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Trinity.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.PURPLE;
    private static final int COST = 0;

    public Trinity() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = 7;
        this.damage = this.baseDamage;
    }

    @Override
    public void applyPowers() {
        super.applyPowers();
        if (AbstractDungeon.player.stance.ID.equals(DivinityStance.STANCE_ID)) {
            this.damage *= 3;
        }
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        super.calculateCardDamage(mo);
        if (AbstractDungeon.player.stance.ID.equals(DivinityStance.STANCE_ID)) {
            this.damage *= 3;
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractGameAction.AttackEffect effect;
        if (p.stance.ID.equals(DivinityStance.STANCE_ID)) {
            effect = AbstractGameAction.AttackEffect.BLUNT_HEAVY;
        }
        else {
            effect = AbstractGameAction.AttackEffect.BLUNT_LIGHT;
        }
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage), effect));
        if (p.stance.ID.equals(DivinityStance.STANCE_ID)) {
            this.addToBot(new ChangeStanceAction(new NeutralStance()));
            this.addToBot(new VFXAction(new EmptyStanceEffect(p.hb.cX, p.hb.cY), 0.1F));
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.selfRetain = true;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}
