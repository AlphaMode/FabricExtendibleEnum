/*
 * Minecraft Forge, AlphaMode
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

import java.lang.reflect.Field;
import java.util.Optional;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class UnsafeHacks
{
    private static final Unsafe UNSAFE;
    static
    {
        try
        {
            final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe)theUnsafe.get(null);
        }
        catch (IllegalAccessException | NoSuchFieldException e)
        {
            throw new RuntimeException("BARF!", e);
        }
    }

    public static void setField(Field data, Object object, Object value)
    {
        long offset = UNSAFE.objectFieldOffset(data);
        UNSAFE.putObject(object, offset, value);
    }

    // Make sure we don't crash if any future versions change field names
    private static Optional<Field> findField(Class<?> clazz, String name)
    {
        for (Field f : clazz.getDeclaredFields())
        {
            if (f.getName().equals(name))
            {
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }

    public static void cleanEnumCache(Class<? extends Enum<?>> enumClass) throws Exception
    {
        findField(Class.class, "enumConstantDirectory").ifPresent(f -> setField(f, enumClass, null));
        findField(Class.class, "enumConstants").ifPresent(f -> setField(f, enumClass, null));
    }
}
