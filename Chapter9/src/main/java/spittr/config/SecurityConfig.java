package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ChannelSecurityConfigurer.RequiresChannelUrl;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import spittr.data.SpitterRepository;
import spittr.security.SpitterUserService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
	
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
        .loginPage("/login")
      .and()
        .logout()
          .logoutSuccessUrl("/")
      .and()
      .rememberMe()
        .tokenRepository(new InMemoryTokenRepositoryImpl())
        .tokenValiditySeconds(2419200)
        .key("spittrKey")
      .and()
       .httpBasic()
         .realmName("Spittr")
      .and()
      .authorizeRequests()
        .antMatchers("/").authenticated()
        .antMatchers("/spitter/me").authenticated()
        .antMatchers(HttpMethod.POST, "/spittles").authenticated()
        .anyRequest().permitAll()
//      .and()
//        .requiresChannel()
//        .antMatchers("/spitter/form").requiresInsecure()
        .and()
        	.csrf().disable();
        ;
  }

// 方案1：基于内存的认证
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .inMemoryAuthentication()
//        .withUser("user").password("password").roles("USER");
//  }
  
  // 方案2：基于数据库的认证
//  @Autowired
//  DataSource dataSource;
//  
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//    	.jdbcAuthentication().dataSource(dataSource)
//    	.usersByUsernameQuery("select username, password, true from Spitter where username=?")
//    	.authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
//    	.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//  }
  
//  方案3：基于LDAP的认证
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.ldapAuthentication()
//  		.userSearchBase("ou=people")
//  		.userSearchFilter("uid={0}")
//  		.groupSearchBase("ou=groups")
//  		.groupSearchFilter("member={0}")
//  		.passwordCompare()
//  		.passwordEncoder(new Md5PasswordEncoder())
//  		.passwordAttribute("password")
//  		;
//  }
  
//方案4：基于LDAP的认证，引用远程LDAP服务器
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication()
//			.userSearchBase("ou=people")
//			.userSearchFilter("uid={0}")
//			.groupSearchBase("ou=groups")
//			.groupSearchFilter("member={0}")
//			.contextSource()
//				.url("ldap://habuma.com:389/dc=habuma,dc=com")
//			;
//	}

//方案5：基于LDAP的认证，配置嵌入式的LDAP服务器
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication()
//			.userSearchBase("ou=people")
//			.userSearchFilter("uid={0}")
//			.groupSearchBase("ou=groups")
//			.groupSearchFilter("member={0}")
////			.passwordCompare()
////				.passwordEncoder(new Md5PasswordEncoder())
////				.passwordAttribute("password")
////				.and()
//			.contextSource()
//				.root("dc=habuma,dc=com")
//				.ldif("classpath:users.ldif")
//			;
//	}
  
//  方案6：自定义用户服务
  @Autowired
  SpitterRepository spitterRepository;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(new SpitterUserService(spitterRepository));
  }
  
}
