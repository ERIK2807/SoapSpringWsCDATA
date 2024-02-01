package com.example.producingwebservice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import io.spring.guides.gs_producing_web_service.GetCountryRequestCDATA;
import io.spring.guides.gs_producing_web_service.GetCountryResponseCDATA;

import org.springframework.lang.NonNull;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(@NonNull ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "countriescdata")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriescdataSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");

	
		wsdl11Definition.setSchema(countriescdataSchema);
		// Personaliza los sufijos de solicitud y respuesta
		// en el contexto de Spring WS, el nombre específico de la operación se toma de la anotación
		// @ResponsePayload
		// @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "getCountryRequestCDATA")
    	// public GetCountryResponseCDATA getCountry(@RequestPayload GetCountryRequestCDATA request) 
		//el sufijo sería getCountry, entonces el arma getCountry+RequestCDATA/ResponseCDATA
		wsdl11Definition.setRequestSuffix("RequestCDATA");
		wsdl11Definition.setResponseSuffix("ResponseCDATA");


		return wsdl11Definition;
	}

	@Bean
	public XsdSchema countriescdataSchema() {
		return new SimpleXsdSchema(new ClassPathResource("countriescdata.xsd"));
	}
}
