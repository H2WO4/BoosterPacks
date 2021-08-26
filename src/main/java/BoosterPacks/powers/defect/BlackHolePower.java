package BoosterPacks.powers.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.actions.defect.TriggerAllOrbsAction;
import BoosterPacks.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BoosterPacks.BoosterPacks.makePowerPath;

public class BlackHolePower extends AbstractPower implements CloneablePowerInterface {

    public static final String POWER_ID = BoosterPacks.makeID("BlackHolePower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("BlackHole84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("BlackHole32.png"));

    public BlackHolePower(final AbstractCreature owner) {
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
        if (orb.ID.equals(Dark.ORB_ID)) {
            this.flash();
            this.addToBot(new TriggerAllOrbsAction(Dark.ORB_ID));
        }
    }


    @Override
    public AbstractPower makeCopy() {
        return new BlackHolePower(owner);
    }
}