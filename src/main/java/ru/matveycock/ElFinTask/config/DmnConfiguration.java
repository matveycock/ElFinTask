package ru.matveycock.ElFinTask.config;

import lombok.AllArgsConstructor;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class DmnConfiguration {

    private Resource resource;
    private ResourceLoader resourceLoader;
    private DmnEngine dmnEngine;

    DmnConfiguration(ResourceLoader resourceLoader, @Lazy DmnEngine dmnEngine){
        this.resourceLoader = resourceLoader;
        this.dmnEngine = dmnEngine;
    }

    @Bean
    public DmnEngine createDmnEngine() {
        DmnEngineConfiguration configuration = DmnEngineConfiguration
                .createDefaultDmnEngineConfiguration();

        DmnEngine dmnEngine = configuration.buildEngine();
        return dmnEngine;
    }

    @Bean
    public DmnDecision createDecision() {
        Resource resource = resourceLoader.getResource("classpath:dmn/definitions.dmn");
        InputStream is = null;
        try {
            is = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DmnDecision dec = dmnEngine.parseDecision("decision", is);
        return dmnEngine.parseDecision("decision", is);
    }
}
