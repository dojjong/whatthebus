package what.the.bus.admin;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import what.the.bus.admin.view.ItextPdfView;
import what.the.bus.admin.view.XlsView;
import what.the.bus.admin.view.XlsxView;

@EnableWebMvc
@Configuration
@ComponentScan("what.the.bus.admin")
public class MyWebConfig extends WebMvcConfigurerAdapter  {

    @Bean("viewResolver")
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean("currencyRateView")
    public View jsonView() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        return view;
    }
    
    @Bean("xlsView")
    public View xlsView() {
    	XlsView view = new XlsView();
        return view;
    }
    
    @Bean
    public ItextPdfView itextPdfView() {
    	ItextPdfView view = new ItextPdfView();
        return view;
    }
    
    @Bean
    public XlsxView xlsxView() {
    	XlsxView view = new XlsxView();
        return view;
    }
}
