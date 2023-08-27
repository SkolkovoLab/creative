/*
 * This file is part of creative, licensed under the MIT license
 *
 * Copyright (c) 2021-2023 Unnamed Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package team.unnamed.creative.atlas;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.Nullable;
import team.unnamed.creative.base.KeyPattern;

/**
 * @sincePackFormat 12
 * @sinceMinecraft 1.19.3
 */
public interface AtlasSource {

    /**
     * @sincePackFormat 12
     * @sinceMinecraft 1.19.3
     */
    static SingleAtlasSource single(Key resource, @Nullable Key sprite) {
        return new SingleAtlasSource(resource, sprite);
    }

    /**
     * @sincePackFormat 12
     * @sinceMinecraft 1.19.3
     */
    static SingleAtlasSource single(Key resource) {
        return single(resource, null);
    }

    /**
     * @sincePackFormat 12
     * @sinceMinecraft 1.19.3
     */
    static DirectoryAtlasSource directory(String source, String prefix) {
        return new DirectoryAtlasSource(source, prefix);
    }

    /**
     * @sincePackFormat 12
     * @sinceMinecraft 1.19.3
     */
    static FilterAtlasSource filter(KeyPattern pattern) {
        return new FilterAtlasSource(pattern);
    }

}