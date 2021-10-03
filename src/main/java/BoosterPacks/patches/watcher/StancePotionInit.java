package BoosterPacks.patches.watcher;

import BoosterPacks.BoosterPacks;
import BoosterPacks.stances.CourageStance;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.GameDictionary;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.potions.StancePotion;

@SpirePatch(clz = StancePotion.class, method = SpirePatch.CONSTRUCTOR)
public class StancePotionInit {
    public static void Postfix(StancePotion __instance) {
        __instance.tips.clear();
        __instance.tips.add(new PowerTip(__instance.name, CardCrawlGame.languagePack.getPotionString(BoosterPacks.getModID() + ":StancePotion").DESCRIPTIONS[0]));
        __instance.tips.add(new PowerTip(TipHelper.capitalize(GameDictionary.CALM.NAMES[0]), (String)GameDictionary.keywords.get(GameDictionary.CALM.NAMES[0])));
        __instance.tips.add(new PowerTip(TipHelper.capitalize(GameDictionary.WRATH.NAMES[0]), (String)GameDictionary.keywords.get(GameDictionary.WRATH.NAMES[0])));
        __instance.tips.add(new PowerTip(TipHelper.capitalize(new CourageStance().name), new CourageStance().description));
    }
}
