package io.whitepaek.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "io.whitepaek.config.autoconfig.DispatcherServletConfig",
                "io.whitepaek.config.autoconfig.TomcatWebServerConfig"
        };
    }

}
