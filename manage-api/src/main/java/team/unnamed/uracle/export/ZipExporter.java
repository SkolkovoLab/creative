/*
 * This file is part of uracle, licensed under the MIT license
 *
 * Copyright (c) 2021-2022 Unnamed Team
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
package team.unnamed.uracle.export;

import org.jetbrains.annotations.Nullable;
import team.unnamed.uracle.pack.ResourcePackLocation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ZipExporter implements ResourceExporter {

    private final File target;

    public ZipExporter(File target) {
        this.target = target;
    }

    @Override
    public @Nullable ResourcePackLocation export(ResourcePackWriter writer)
            throws IOException {

        if (!target.exists()) {
            File parent = target.getParentFile();
            if (!parent.exists() && !parent.mkdirs()) {
                throw new IOException("Cannot create parent" +
                        " folder for target ZIP");
            }
            if (!target.createNewFile()) {
                throw new IOException("Cannot create target ZIP file");
            }
        }

        // write resource pack
        try (TreeOutputStream output = TreeOutputStream.forZip(
                new ZipOutputStream(new FileOutputStream(target))
        )) {
            writer.write(output);
        }
        return null;
    }

}
