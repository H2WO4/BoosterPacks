package BoosterPacks.cards.purple;

import BoosterPacks.BoosterPacks;
import BoosterPacks.cards.tempCards.ChooseCourage;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.optionCards.ChooseCalm;
import com.megacrit.cardcrawl.cards.optionCards.ChooseWrath;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Zen extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Zen.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Zen.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.PURPLE;
    private static final int COST = 1;

    public Zen() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.selfRetain = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> stanceChoices = new ArrayList<>();
        stanceChoices.add(new ChooseCalm());
        stanceChoices.add(new ChooseWrath());
        stanceChoices.add(new ChooseCourage());
        this.addToBot(new ChooseOneAction(stanceChoices));
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
