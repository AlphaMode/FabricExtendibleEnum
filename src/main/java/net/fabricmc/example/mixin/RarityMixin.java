package net.fabricmc.example.mixin;

import net.fabricmc.example.IExtensibleEnum;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Rarity.class)
public class RarityMixin implements IExtensibleEnum {

    static {
        create("GREEN", Formatting.DARK_GREEN);
    }

    private static Rarity create(String name, Formatting p_43028_) {
        throw new IllegalStateException("Enum not extended");
    }
}
