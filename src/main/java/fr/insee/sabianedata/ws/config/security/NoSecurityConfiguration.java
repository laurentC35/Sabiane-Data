package fr.insee.sabianedata.ws.config.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "fr.insee.sabianedata.security", havingValue = "none")
public class NoSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// tout en https
	http.authorizeRequests().antMatchers("/**").permitAll();
	http.headers().frameOptions().disable();
	http.csrf().disable();
    }
}
