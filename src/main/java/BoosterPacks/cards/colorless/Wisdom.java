package BoosterPacks.cards.colorless;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Wisdom extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Wisdom.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Wisdom.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = CardColor.COLORLESS;
    private static final int COST = 1;

    public Wisdom() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int strength = p.hasPower(StrengthPower.POWER_ID) ? p.getPower(StrengthPower.POWER_ID).amount : 0;
        int dexterity = p.hasPower(DexterityPower.POWER_ID) ? p.getPower(DexterityPower.POWER_ID).amount : 0;
        int mean = (strength + dexterity + 1) / 2;
        
        this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, mean-strength), mean-strength));
        this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, mean-dexterity), mean-dexterity));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
            initializeDescription();
        }
    }
}
