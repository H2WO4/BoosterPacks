package BoosterPacks.cards.blue;

import BoosterPacks.BoosterPacks;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.MoveCardsAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static BoosterPacks.BoosterPacks.makeCardPath;

public class DictionaryAttack extends CustomCard {

    public static final String ID = BoosterPacks.makeID(DictionaryAttack.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("DictionaryAttack.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.BLUE;
    private static final int COST = 2;

    public DictionaryAttack() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = 14;
        this.damage = this.baseDamage;
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        int end = Math.min(this.magicNumber, p.drawPile.size() - 1);
        for (int i = end; i > 0; i--) {
            temp.addToTop(p.drawPile.getNCardFromTop(i));
        }
        temp.sortByRarity(false);
        this.addToBot(new MoveCardsAction(p.hand, temp, (card) -> true, 1, (cards) -> {
            p.drawPile.removeCard(cards.get(0));
        }));
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(2);
            this.upgradeMagicNumber(2);
            initializeDescription();
        }
    }
}
