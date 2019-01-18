package hu.simplesoft.springtutorial.Biblioteca.data.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;

@ControllerAdvice
public class ExceptionController {

	private static final Logger LOGGER = LogManager.getLogger(ExceptionController.class);	
	
	@ExceptionHandler(ServiceException.class)
	public void handleServiceException(ServiceException e) {
		LOGGER.error(ExceptionConstants.ServiceExceptionConstant.SERVICE_EXCEPTION);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public void handleRuntimeException(RuntimeException e) {
		LOGGER.error(ExceptionConstants.RuntimeExcepitonConstant.RUNTIME_EXCEPTION);
	}
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e) {
		LOGGER.error(ExceptionConstants.ExceptionConstant.EXCEPTION);
	}
	
}
