//package cn.com.jinkang.module.standard.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class webConfig implements WebMvcConfigurer {
//
//    @Bean
//    public AuthInterceptor initAuthInterceptor() {
//        return new AuthInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(initAuthInterceptor())
//                .addPathPatterns("/index/**")
//                .addPathPatterns("/equipment/**")
//                .addPathPatterns("/process/**")
//                .excludePathPatterns("/index/login")
//                .excludePathPatterns("/index/refreshToken");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("http://localhost:8081")
//                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD").exposedHeaders("token")
//                .allowCredentials(true).maxAge(3600 * 24);
//    }
//}
