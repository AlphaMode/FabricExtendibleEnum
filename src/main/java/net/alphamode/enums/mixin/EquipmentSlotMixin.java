package net.alphamode.enums.mixin;

import net.alphamode.enums.IExtensibleEnum;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EquipmentSlot.class)
public class EquipmentSlotMixin implements IExtensibleEnum<EquipmentSlot> {
    private static EquipmentSlot create(String name, EquipmentSlot.Type type, int i, int j, String id) {
        throw new IllegalStateException("Enum not extended");
    }

    @Override
    public EquipmentSlot createEnum(String name, Object... args) {
        return create(name, (EquipmentSlot.Type) args[0], (int) args[1], (int) args[2], (String) args[3]);
    }

    @Mixin(EquipmentSlot.Type.class)
    public static class EquipmentSlotTypeMixin implements IExtensibleEnum<EquipmentSlot.Type> {
        private static EquipmentSlot.Type create(String name) {
            throw new IllegalStateException("Enum not extended");
        }

        @Override
        public EquipmentSlot.Type createEnum(String name) {
            return create(name);
        }
    }
}
