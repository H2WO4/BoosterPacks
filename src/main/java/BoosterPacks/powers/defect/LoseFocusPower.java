package BoosterPacks.powers.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;

import static BoosterPacks.BoosterPacks.makePowerPath;

public class LoseFocusPower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = BoosterPacks.makeID("LoseFocusPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("LoseFocus84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("LoseFocus32.png"));

    public LoseFocusPower(final AbstractCreature owner, final int amount) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.DEBUFF;
        isTurnBased = false;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        updateDescription();
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        this.flash();
        if (this.owner.getPower(FocusPower.POWER_ID).amount - this.amount == 0) {
            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, FocusPower.POWER_ID));
        }
        else {
            this.addToBot(new ApplyPowerAction(this.owner, this.owner, new FocusPower(this.owner, -this.amount), -this.amount));
        }
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, LoseFocusPower.POWER_ID));
    }

    @Override
    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy() {
        return new LoseFocusPower(owner, amount);
    }
}