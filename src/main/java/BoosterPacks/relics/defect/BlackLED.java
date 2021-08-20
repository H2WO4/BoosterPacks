package BoosterPacks.relics.defect;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class BlackLED extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("BlackLED");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public BlackLED() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
