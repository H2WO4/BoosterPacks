package BoosterPacks.cards.red;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Desecration extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Desecration.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Desecration.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.RED;
    private static final int COST = 1;

    public Desecration() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = 6;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new LoseHPAction(p, p, 6));
        CardGroup total = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c: p.drawPile.group) {
            if (!c.cardID.equals(Desecration.ID)) {
                total.addToTop(c);
            }
        }
        for (AbstractCard c: p.discardPile.group) {
            if (!c.cardID.equals(Desecration.ID)) {
                total.addToTop(c);
            }
        }
        for (AbstractCard c: p.exhaustPile.group) {
            if (!c.cardID.equals(Desecration.ID)) {
                total.addToTop(c);
            }
        }
        total.sortByRarity(false);
        this.addToBot(new SelectCardsAction(total.group, 1, "Choose a card", (cards) -> {
            AbstractCard card = cards.get(0).makeStatEquivalentCopy();
            this.addToTop(new MakeTempCardInHandAction(card));
        }));
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