package BoosterPacks.cards.red;

import BoosterPacks.BoosterPacks;
import BoosterPacks.actions.common.PullAllCardsFromPileAction;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class Abyss extends CustomCard {

    public static final String ID = BoosterPacks.makeID(Abyss.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Abyss.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.RED;
    private static final int COST = 1;
    private AbstractCard card;

    public Abyss() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardGroup draw = p.drawPile;
        draw.sortByRarity(false);
        this.addToBot(new SelectCardsAction(draw.group, 1, "Choose a card", (cards) -> {
            AbstractCard card = cards.get(0);
            AbstractDungeon.actionManager.addToTop(new PullAllCardsFromPileAction(p.exhaustPile, card.cardID));
            AbstractDungeon.actionManager.addToTop(new PullAllCardsFromPileAction(p.drawPile, card.cardID));
            AbstractDungeon.actionManager.addToTop(new PullAllCardsFromPileAction(p.discardPile, card.cardID));
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