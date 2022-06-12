package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/* Annotation that can be used to indicate that configuration properties should be bound using constructor arguments
   rather than by calling setters. Can be added at the type level (if there is an unambiguous constructor) or on the
   actual constructor to use.

   Note: To use constructor binding the class must be enabled using @EnableConfigurationProperties or configuration
   property scanning. Constructor binding cannot be used with beans that are created by the regular Spring mechanisms
   (e.g. @Component beans, beans created via @Bean methods or beans loaded using @Import).
*/

@ConstructorBinding
@ConfigurationProperties("guru")
public class SfgConstructorConfig {

    private final String username;
    private final String password;
    private final String jdbcUrl;

    public SfgConstructorConfig(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
