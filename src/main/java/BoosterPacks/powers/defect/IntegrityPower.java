package BoosterPacks.powers.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BoosterPacks.BoosterPacks.makePowerPath;

public class IntegrityPower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = BoosterPacks.makeID("IntegrityPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("Integrity84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("Integrity32.png"));

    public IntegrityPower(final AbstractCreature owner, final int amount) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;
        this.canGoNegative = true;

        type = PowerType.BUFF;
        isTurnBased = false;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        updateDescription();
    }

    @Override
    public void onInitialApplication() {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractOrb o: p.orbs) {
            if (!(o instanceof EmptyOrbSlot)) {
                o.updateDescription();
                if (o.ID.equals(Dark.ORB_ID)) {
                    o.evokeAmount += this.amount;
                }
            }
        }
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractOrb o: p.orbs) {
            if (!(o instanceof EmptyOrbSlot)) {
                o.updateDescription();
                if (o.ID.equals(Dark.ORB_ID)) {
                    o.evokeAmount += stackAmount;
                }
            }
        }
    }

    @Override
    public void reducePower(int reduceAmount) {
        super.reducePower(reduceAmount);
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractOrb o: p.orbs) {
            if (!(o instanceof EmptyOrbSlot)) {
                o.updateDescription();
                if (o.ID.equals(Dark.ORB_ID)) {
                    o.evokeAmount -= reduceAmount;
                }
            }
        }
    }

    @Override
    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy() {
        return new IntegrityPower(owner, amount);
    }
}