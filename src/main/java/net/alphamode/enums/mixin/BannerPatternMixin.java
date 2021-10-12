package net.alphamode.enums.mixin;

import net.alphamode.enums.IExtensibleEnum;
import net.minecraft.block.entity.BannerPattern;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BannerPattern.class)
public class BannerPatternMixin implements IExtensibleEnum<BannerPattern> {
    private static BannerPattern create(String enumName, String fileNameIn, String hashNameIn) {
        throw new IllegalStateException("Enum not extended");
    }

    private static BannerPattern create(String enumName, String fileNameIn, String hashNameIn, boolean hasPatternItem) {
        throw new IllegalStateException("Enum not extended");
    }

    @Override
    public BannerPattern createEnum(String name, Object... args) {
        return create(name, (String) args[0], (String) args[1], (boolean) args[2]);
    }
}
