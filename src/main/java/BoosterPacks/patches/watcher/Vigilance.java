package BoosterPacks.patches.watcher;

import BoosterPacks.cards.choiceCards.ChooseCourage;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.purple.Vigilance;
import com.megacrit.cardcrawl.cards.choiceCards.ChooseCalm;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ChooseAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch(clz = Vigilance.class, method = "use")
public class Vigilance {
    public static void Replace(Vigilance __instance) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, __instance.block));
        ArrayList<AbstractCard> choices = new ArrayList<>();
        choices.add(new ChooseCalm());
        choices.add(new ChooseCourage());
        AbstractDungeon.actionManager.addToBottom(new ChooseAction(choices));
    }
}
