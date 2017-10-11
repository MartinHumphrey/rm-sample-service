package uk.gov.ons.ctp.response.sample.config;

import net.sourceforge.cobertura.CoverageIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.core.VaultTemplate;


/**
 * The apps main holder for centralized config read from application.yml or env
 * vars
 *
 */
@CoverageIgnore
@Configuration
@ConfigurationProperties
@Data
@EnableRetry
@VaultPropertySource("secret/SampleService")
public class AppConfig {

  @Autowired
  private VaultTemplate vaultTemplate;

  @Bean
  public void setUpVault() {
    ConfigurableApplicationContext ctx = new GenericApplicationContext();
    MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
  }

  private PartySvc partySvc;
  private SampleUnitDistribution sampleUnitDistribution;
  private DataGrid dataGrid;
  private SwaggerSettings swaggerSettings;

}
