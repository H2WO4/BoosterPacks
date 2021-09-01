package BoosterPacks.powers.colorless;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BoosterPacks.BoosterPacks.makePowerPath;

public class BlessingPower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = BoosterPacks.makeID("BlessingPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("Blessing84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("Blessing32.png"));

    public BlessingPower(final AbstractCreature owner, final int amount) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;
        isTurnBased = false;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        this.flash();
        this.addToBot(new GainEnergyAction(this.amount));
    }

    @Override
    public void updateDescription() {
        if (this.amount == 1) {
            description = DESCRIPTIONS[0];
        }
        else if (this.amount == 2) {
            description = DESCRIPTIONS[1];
        }
        else if (this.amount == 3) {
            description = DESCRIPTIONS[2];
        }
        else {
            description = DESCRIPTIONS[3] + amount + DESCRIPTIONS[4];
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new BlessingPower(owner, amount);
    }
}