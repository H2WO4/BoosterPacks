package BoosterPacks.relics.shared;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.BaseMod;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class PlasticGloves extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("PlasticGloves");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public PlasticGloves() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.MAGICAL);
    }

    @Override
    public void onEquip() {
        BaseMod.MAX_HAND_SIZE += 2;
    }

    @Override
    public void onUnequip() {
        BaseMod.MAX_HAND_SIZE -= 2;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
