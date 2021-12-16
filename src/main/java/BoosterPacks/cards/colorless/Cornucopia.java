package BoosterPacks.cards.colorless;

import BoosterPacks.BoosterPacks;
import BoosterPacks.cards.choiceCards.Tools;
import BoosterPacks.cards.choiceCards.Fruit;
import BoosterPacks.cards.choiceCards.Treasure;
import basemod.abstracts.CustomCard;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static BoosterPacks.BoosterPacks.makeCardPath;

import java.util.ArrayList;

public class Cornucopia extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Cornucopia.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Cornucopia.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.COLORLESS;
    private static final int COST = 1;
    private ArrayList<AbstractCard> choices;

    public Cornucopia() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = 9;
        this.magicNumber = this.baseMagicNumber;
        this.baseBlock = 5;
        this.block = this.baseBlock;
        this.baseDamage = 1;
        this.damage = this.baseDamage;
        this.exhaust = true;

        this.choices = new ArrayList<AbstractCard>();
        this.choices.add(new Fruit());
        this.choices.add(new Treasure());
        this.choices.add(new Tools());
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ChooseOneAction(this.choices));
    }

    @Override
    public void applyPowers() {}

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            for (AbstractCard c : this.choices) {
                c.upgrade();
            }
            
            this.upgradeMagicNumber(3);
            this.upgradeBlock(3);
            this.upgradeDamage(1);
            initializeDescription();
        }
    }
}
