package com.example.tp5.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {

    @PostMapping("/meteo")
    public String showMeteo(@RequestParam(name="address", required=false, defaultValue="showAddress") String address, Model model) {
        model.addAttribute("adresseTemplate", address);
        return "meteo";
    }
    
    public void request() {
    	SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
    		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.univ-lemans.fr"),3128);
    		clientHttpReq.setProxy(proxy);
    		
    		RestTemplate restTemplate = new RestTemplate(clientHttpReq);
    		Object c = restTemplate.getForObject("https://api-adresse.data.gouv.fr/search/?q=3+La+goumardi%C3%A8re+Saint-Jean-de-la-Motte",Object.class);
    }
}
