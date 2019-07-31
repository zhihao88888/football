package t.z.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import t.z.h.service.AnalyzeService;
import t.z.h.service.DltService;
import t.z.h.utils.SpringUtils;

@Configuration
@ComponentScan({ "t.z" })
@EnableAutoConfiguration
@EnableScheduling
@EntityScan(basePackages = { "t.z" })
@EnableJpaRepositories(basePackages = { "t.z" })
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		try {
			SpringApplication springApplication = new SpringApplication(Application.class);
			springApplication.run(args);
			// dlt
			long startTime = System.currentTimeMillis();
			getDltService().getDlt();
			long endTime = System.currentTimeMillis();
			System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
			// jc
			while (true) {
				System.out.println("请输入赛别以及胜平负赔率用,隔开:\n");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				getAnalyzeService().handleData(reader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} finally {
			System.out.print("长时间未使用，连接已关闭");
		}
	}

	private static AnalyzeService getAnalyzeService() {
		AnalyzeService bean = SpringUtils.getBean(AnalyzeService.class);
		return bean;
	}

	private static DltService getDltService() {
		DltService bean = SpringUtils.getBean(DltService.class);
		return bean;
	}

}