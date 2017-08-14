package com.prescription.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(6006);//live
//		container.setPort(6001);//development
	}

}
