package BoosterPacks.cards.colorless;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Memories extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Memories.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Skill.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.COLORLESS;
    private static final int COST = 0;

    public Memories() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardGroup temp1 = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        CardGroup temp2 = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c: p.drawPile.group) {
            temp1.addToTop(c);
        }
        for (AbstractCard c: p.discardPile.group) {
            temp2.addToTop(c);
        }
        for (AbstractCard c: temp1.group) {
            p.drawPile.removeCard(c);
            p.discardPile.addToTop(c);
        }
        for (AbstractCard c: temp2.group) {
            p.discardPile.removeCard(c);
            p.drawPile.addToTop(c);
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.exhaust = false;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}
