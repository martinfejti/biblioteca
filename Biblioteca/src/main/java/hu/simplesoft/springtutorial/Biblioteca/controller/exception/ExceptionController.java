package hu.simplesoft.springtutorial.Biblioteca.controller.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hu.simplesoft.springtutorial.Biblioteca.service.exception.ServiceException;

@ControllerAdvice
public class ExceptionController {

	private static final Logger LOGGER = LogManager.getLogger(ExceptionController.class);	
	private static final String ERR = "Error";
	
	@ExceptionHandler(ServiceException.class)
	public ExceptionObject handleServiceException(ServiceException e) {
		LOGGER.error(ExceptionConstants.ServiceExceptionConstant.SERVICE_EXCEPTION);
		return new ExceptionObject(ERR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ExceptionObject handleRuntimeException(RuntimeException e) {
		LOGGER.error(ExceptionConstants.RuntimeExcepitonConstant.RUNTIME_EXCEPTION);
		return new ExceptionObject(ERR);
	}
	
	@ExceptionHandler(Exception.class)
	public ExceptionObject handleException(Exception e) {
		LOGGER.error(ExceptionConstants.ExceptionConstant.EXCEPTION);
		return new ExceptionObject(ERR);
	}
	
}
