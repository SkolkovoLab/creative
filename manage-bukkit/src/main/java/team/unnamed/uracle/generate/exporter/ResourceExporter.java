package team.unnamed.uracle.generate.exporter;

import org.jetbrains.annotations.Nullable;
import team.unnamed.uracle.generate.TreeWriteable;
import team.unnamed.uracle.resourcepack.ResourcePackLocation;

import java.io.IOException;

/**
 * Interface for exporting resources packs
 */
public interface ResourceExporter {

    /**
     * Exports the data written by the
     * given {@code writer}
     */
    @Nullable
    ResourcePackLocation export(TreeWriteable writer) throws IOException;

}