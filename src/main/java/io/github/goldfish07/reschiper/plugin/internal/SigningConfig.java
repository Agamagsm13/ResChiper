package io.github.goldfish07.reschiper.plugin.internal;

import com.android.build.api.dsl.ApplicationBuildType;
import com.android.build.api.dsl.ApplicationExtension;
import com.android.build.api.variant.ApplicationVariant;
import io.github.goldfish07.reschiper.plugin.model.KeyStore;
import org.gradle.api.Project;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class SigningConfig {
    @Contract("_, _ -> new")
    public static @NotNull KeyStore getSigningConfig(@NotNull Project project, @NotNull ApplicationVariant variant) {
        ApplicationExtension android = project.getExtensions().getByType(ApplicationExtension.class);
        ApplicationBuildType buildType = android.getBuildTypes().getByName(variant.getBuildType());
        com.android.build.api.dsl.SigningConfig signingConfig = buildType.getSigningConfig();
        if (signingConfig == null)
            return new KeyStore(null, null, null, null);
        return new KeyStore(
                signingConfig.getStoreFile(),
                signingConfig.getStorePassword(),
                signingConfig.getKeyAlias(),
                signingConfig.getKeyPassword()
        );
    }
}
