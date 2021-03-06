package BoosterPacks.powers.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.actions.defect.InvokeAction;
import BoosterPacks.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BoosterPacks.BoosterPacks.makePowerPath;

public class GalvanicAuraPower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = BoosterPacks.makeID("GalvanicAuraPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("placeholder_power84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("placeholder_power32.png"));

    public GalvanicAuraPower(final AbstractCreature owner) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = -1;

        type = PowerType.BUFF;
        isTurnBased = false;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        updateDescription();
    }

    @Override
    public void updateDescription() {
        description = DESCRIPTIONS[0];
    }

    @Override
    public void onEvokeOrb(AbstractOrb orb) {
        if (!orb.ID.equals(Lightning.ORB_ID)) {
            this.flash();
            this.addToBot(new InvokeAction(new Lightning()));
        }
    }


    @Override
    public AbstractPower makeCopy() {
        return new GalvanicAuraPower(owner);
    }
}