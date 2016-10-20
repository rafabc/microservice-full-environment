package com.micro.car.listener;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PortListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

	private int port;

	@Override
	public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {
		int port = event.getEmbeddedServletContainer().getPort();
	}

}