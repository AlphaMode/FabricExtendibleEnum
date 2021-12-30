/*
 * AlphaMode
 * Copyright (c) 2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.alphamode.enums;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;

/**
 * A util class for adding to some common vanilla enums
 */
public class EnumUtil {

    private static final MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

    private static Method getCreateMethod(Class<?> clazz, Class<?>... args) throws NoSuchMethodException {
        return clazz.getDeclaredMethod("create", args);
    }

    public static Rarity createRarity(String name, Formatting color) {
        return ((IExtensibleEnum<Rarity>) (Object) Rarity.COMMON).createEnum(name, color);
    }

    public static BannerPattern createBannerPattern(String name, String main, String hashNameIn) {
        return ((IExtensibleEnum<BannerPattern>) (Object) BannerPattern.BASE).createEnum(name, main, hashNameIn, false);
    }

    public static BannerPattern createBannerPattern(String name, String main, String hashNameIn, boolean hasPatternItem) {
        return ((IExtensibleEnum<BannerPattern>) (Object) BannerPattern.BASE).createEnum(name, main, hashNameIn, hasPatternItem);
    }

    public static <T> T create(Class<T> enumClass, Class<?> classes, String name, Object... args) {
        try {
            return (T) getCreateMethod(enumClass, classes).invoke(null, args);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
