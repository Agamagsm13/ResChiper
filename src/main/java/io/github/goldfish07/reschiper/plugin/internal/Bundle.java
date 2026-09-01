package io.github.goldfish07.reschiper.plugin.internal;

import com.android.build.api.artifact.SingleArtifact;
import com.android.build.api.variant.ApplicationVariant;
import org.gradle.api.file.RegularFile;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class Bundle {
    public static @NotNull Path getBundleFilePath(@NotNull ApplicationVariant variant) {
        RegularFile bundleFile = variant.getArtifacts().get(SingleArtifact.BUNDLE.INSTANCE).get();
        return bundleFile.getAsFile().toPath();
    }
}
