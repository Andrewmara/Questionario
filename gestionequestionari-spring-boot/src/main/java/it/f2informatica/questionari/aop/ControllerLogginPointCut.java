package it.f2informatica.questionari.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


public class ControllerLogginPointCut {
	@Configuration
	@Aspect
	public class ControllerLoggingPointCut {
		private Logger logger = LoggerFactory.getLogger(ControllerLoggingPointCut.class);
		@After("execution(* it.f2informatica.questionari.controller..*(..))")
		public void log(JoinPoint point) {
			logger.debug("Chiamato il metodo: {}, argomenti {}",point.getSignature().getName(),point.getArgs());
		}
	}

}
