package it.f2informatica.questionari.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


public class ExceptionLogginPointCut {
	@Configuration
	@Aspect
	public class ExceptionLoggerPointCut {
		private Logger logger = LoggerFactory.getLogger(ExceptionLoggerPointCut.class);

		@AfterThrowing(pointcut = "execution(* it.f2informatica.questionari.*.*.*(..))", throwing = "ex")
		public void logError(Exception ex) {
			logger.error("Error: {}", ex.toString());
		}
	}

}
