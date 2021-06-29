package BoosterPacks.relics.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.powers.defect.LoseFocusPower;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.FocusPower;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class AdditionalMemory extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("AdditionalMemory");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public AdditionalMemory() {
        super(ID, IMG, OUTLINE, RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void atTurnStart() {
        AbstractPlayer p = AbstractDungeon.player;
        if (!p.hasEmptyOrb()) {
            this.addToBot(new ApplyPowerAction(p, p, new FocusPower(p, 1), 1));
            this.addToBot(new ApplyPowerAction(p, p, new LoseFocusPower(p, 1), 1));
        }
    }
}
