package com.docconverter.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

	public Executor taskExecuiter() {
		final ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
		poolExecutor.setCorePoolSize(2);
		poolExecutor.setMaxPoolSize(2);
		poolExecutor.setQueueCapacity(100);
		poolExecutor.setThreadNamePrefix("FilePool - ");
		poolExecutor.initialize();
		return poolExecutor;
		
	}
}
