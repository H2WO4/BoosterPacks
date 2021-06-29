package BoosterPacks.patches.defect;

import BoosterPacks.patches.BoosterTags;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;

@SpirePatch(clz = com.megacrit.cardcrawl.cards.blue.Claw.class, method = SpirePatch.CONSTRUCTOR)
public class Claw {
    public static void Postfix(com.megacrit.cardcrawl.cards.blue.Claw __instance) {
        __instance.tags.add(BoosterTags.CLAW);
    }
}