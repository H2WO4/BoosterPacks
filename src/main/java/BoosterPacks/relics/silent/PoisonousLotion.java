package BoosterPacks.relics.silent;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class PoisonousLotion extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("PoisonousLotion");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));
    public boolean used;

    public PoisonousLotion() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
