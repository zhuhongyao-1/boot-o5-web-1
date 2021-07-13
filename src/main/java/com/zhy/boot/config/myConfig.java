package com.zhy.boot.config;

import com.zhy.boot.entity.Pet;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class myConfig /*implements WebMvcConfigurer*/ {
    @Bean
    public OrderedHiddenHttpMethodFilter orderedHiddenHttpMethodFilter(){
        OrderedHiddenHttpMethodFilter orderedHiddenHttpMethodFilter = new OrderedHiddenHttpMethodFilter();
        orderedHiddenHttpMethodFilter.setMethodParam("_m");
        return orderedHiddenHttpMethodFilter;

    }


//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//         urlPathHelper.setRemoveSemicolonContent(false);
//         configurer.setUrlPathHelper(urlPathHelper);
//
//    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
            public void addFormatters(FormatterRegistry registry){
                registry.addConverter(new Converter<String, Pet>() {

                    @Override
                    public Pet convert(String s) {
                        if (!StringUtils.isEmpty(s)){
                            Pet pet = new Pet();
                            String[] split = s.split(",");
                            pet.setName(split[1]);
                            pet.setAge(Integer.valueOf(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }
        };
    }
}
