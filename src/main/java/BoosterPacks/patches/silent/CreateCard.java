package BoosterPacks.patches.silent;

import BoosterPacks.powers.silent.MasteryPower;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

@SpirePatch(clz = MakeTempCardInHandAction.class, method = "update")
public class CreateCard {
    public static void Prefix(MakeTempCardInHandAction __instance)
    {
        AbstractCard c = ReflectionHacks.getPrivate(__instance, MakeTempCardInHandAction.class, "c");
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasPower(MasteryPower.POWER_ID) && c.cardID.equals(Shiv.ID) && __instance.amount > 1) {
            AbstractPower mastery = p.getPower(MasteryPower.POWER_ID);
            mastery.flash();
            __instance.amount += mastery.amount;
        }
    }
}