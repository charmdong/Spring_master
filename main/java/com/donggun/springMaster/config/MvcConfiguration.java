package com.donggun.springMaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.donggun.springMaster.interceptor.AuthInterceptor;
import com.donggun.springMaster.interceptor.LoginInterceptor;
import com.donggun.springMaster.interceptor.MeasuringInterceptor;

/**
 * MVC 커스텀 설정
 * 
 * @author donggun.Chung
 * @since 2021.05.03.
 * @version 1.0
 */

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * view-controller 설정 - 단순히 요청 경로에 알맞은 뷰 이름만 리턴해주는 경우
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/user/loginForm").setViewName("user/loginForm");
		registry.addViewController("/user/joinForm").setViewName("user/joinForm");
		registry.addViewController("/user/detailForm").setViewName("user/detail");
	}

	/**
	 * 디폴트 서블릿 핸들러 - css, js, jsp 등에 대한 요청이 들어오면 디폴트 서블릿에 다시 전달하는 핸들러
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 정적 자원 매핑, 위치 및 캐시 시간 설정
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
				.addResourceLocations("/img/", "/WEB-INF/resources")
				.setCachePeriod(60);
	}

	/**
	 * 인터셉터 추가
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(measuringInterceptor())
				.addPathPatterns("/**");
		
		registry.addInterceptor(loginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/index")
				.excludePathPatterns("/user/loginForm")
				.excludePathPatterns("/user/joinForm");
		
		registry.addInterceptor(authInterceptor())
				.addPathPatterns("/user/detail");
	}

	@Bean
	public MeasuringInterceptor measuringInterceptor() {
		return new MeasuringInterceptor();
	}
	
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
}
