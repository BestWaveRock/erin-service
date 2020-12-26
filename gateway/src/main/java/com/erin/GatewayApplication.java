package com.erin;

import com.erin.gateway.filters.pre.SimpleFilter;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzh
 */
@EnableSwagger2Doc
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {
  private static Logger log = LoggerFactory.getLogger(GatewayApplication.class);

  @Autowired
  RouteLocator routeLocator;

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }

  @Component
  @Primary
  class DocumentationConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
      List<SwaggerResource> resources = new ArrayList<>();
      List<Route> routes = routeLocator.getRoutes();
      //在这里遍历的时候，可以排除掉敏感微服务的路由
      routes.forEach(route -> resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"),"2.0")));
      return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
      SwaggerResource swaggerResource = new SwaggerResource();
      swaggerResource.setName(name);
      swaggerResource.setLocation(location);
      swaggerResource.setSwaggerVersion(version);
      return swaggerResource;
    }
  }
//
//  @Bean
//  public PatternServiceRouteMapper serviceRouteMapper() {
//    return new PatternServiceRouteMapper(
//            "(?<project>^.+)Srvs",
//            "${project}");
//  }
}
