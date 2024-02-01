package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountryRequestCDATA;
import io.spring.guides.gs_producing_web_service.GetCountryResponseCDATA;


@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private CountryRepository countryRepository;
    // private static final String XML_CONTENT_TEMPLATE = "<![CDATA[%s]]>";
    
    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequestCDATA")
    @ResponsePayload //importante para que se muestre el operation properties del soap
    public GetCountryResponseCDATA getCountry(@RequestPayload GetCountryRequestCDATA request) {
        GetCountryResponseCDATA response = new GetCountryResponseCDATA();
        Country country = countryRepository.findCountry(request.getName());
    
        // Convertir el objeto Country a una cadena de CDATA
        String countryXml = convertCountryToXml(country);
        response.setCountry(countryXml);
    
        return response;
    }
   
    private String convertCountryToXml(Country country) {
        // Lógica para convertir el objeto Country a una cadena XML
        // (puedes usar JAXB, un generador de XML o cualquier otra técnica)
        // Aquí, simplemente se usa una cadena de ejemplo para ilustrar el punto.
        return "<city>" + country.getCity() + "</city>\n" +
               "<population>" + country.getPopulation() + "</population>\n" +
               "<capital>" + country.getCapital() + "</capital>\n" +
               "<currency>" + country.getCurrency() + "</currency>";
    }
}
