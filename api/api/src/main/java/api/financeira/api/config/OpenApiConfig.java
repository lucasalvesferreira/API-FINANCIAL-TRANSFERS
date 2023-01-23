package api.financeira.api.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("PROJECT-API-FINANCIAL-TRANSFERS")
                        .version("v1")
                        .description("Api feito por Lucas Alves Ferreira.")
                        .termsOfService("https://www.linkedin.com/in/lucas-alves-426304112/")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://github.com/lucasalvesferreira")
                        )
                );

    }

}
