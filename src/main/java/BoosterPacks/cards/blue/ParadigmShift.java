package BoosterPacks.cards.blue;

import BoosterPacks.BoosterPacks;
import BoosterPacks.powers.defect.IntegrityPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FocusPower;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class ParadigmShift extends CustomCard {

    public static final String ID = BoosterPacks.makeID(ParadigmShift.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("ParadigmShift.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = CardColor.BLUE;
    private static final int COST = 1;

    public ParadigmShift() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = 4;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int focus = p.hasPower(FocusPower.POWER_ID) ? p.getPower(FocusPower.POWER_ID).amount : 0;
        this.addToBot(new ApplyPowerAction(p, p, new IntegrityPower(p, focus + this.magicNumber), focus + this.magicNumber));
        this.addToBot(new RemoveSpecificPowerAction(p, p, FocusPower.POWER_ID));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
            initializeDescription();
        }
    }
}
