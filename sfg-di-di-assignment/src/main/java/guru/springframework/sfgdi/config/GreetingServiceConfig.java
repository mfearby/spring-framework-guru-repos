package guru.springframework.sfgdi.config;

import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

// Moved these to application.properties (which is automatically parsed by Spring _BOOT_)
// @PropertySource("classpath:datasource.properties")

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    // Now moved to XML spring config example in resources folder
    // @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    // Do this in a @Configuration class to create a spring bean for a
    // 3rd party library where you can't add a @Component on it yourself.
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean("i18nService") // need to specify bean name because can't have two methods here called 'i18nService'
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile("dog")
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Primary
    @Profile({"cat", "default"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }


// Before using SfgConfiguration as the only argument:
//    @Value("${guru.username}") String username,
//    @Value("${guru.password}") String password,
//    @Value("${guru.jdbcUrl}") String jdbcUrl)
    @Bean
    FakeDataSource fakeDataSource(SfgConfiguration sfgConfig)
    {
        // Adding an environment variable called GURU_USERNAME will
        // automatically override a property named guru.username

        // You can override properties on the command-line like so:
        // --guru.password=PasswordFromCommandLine

        // Vales given on the command-line take precedence over environment variables

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConfig.getUsername());
        fakeDataSource.setPassword(sfgConfig.getPassword());
        fakeDataSource.setJdbcUrl(sfgConfig.getJdbcUrl());
        return fakeDataSource;
    }
}
