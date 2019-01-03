package hu.simplesoft.springtutorial.Biblioteca.data.util;

public interface Constants {

	interface AddressDaoErrorLogMessages{
		String CREATE_FAILED = "Address creation has failed!";
		String UPDATE_FAILED = "Address modification has failed!";
		String DELETE_FAILED = "Address deletion has failed!";
	}
	
	interface AuthorDaoErrorMessages{
		String CREATE_FAILED = "Author creation has failed!";
		String UPDATE_FAILED = "Author modification has failed!";
		String DELETE_FAILED = "Author deletion has failed!";
	}
	
	interface BookDaoErrorLogMessage{
		String CREATE_FAILED = "Book creation has failed!";
		String UPDATE_FAILED = "Book modification has failed!";
		String DELETE_FAILED = "Book deletion has failed!";
	}
	
	interface LibraryDaoErrorMessage{
		String CREATE_FAILED = "Library creation has failed!";
		String UPDATE_FAILED = "Library modification has failed!";
		String DELETE_FAILED = "Library deletion has failed!";
	}
	
	interface LoanDaoErrorLogMessage{
		String CREATE_FAILED = "Loan creation has failed!";
		String UPDATE_FAILED = "Loan modification has failed!";
		String DELETE_FAILED = "Loan deletion has failed!";
	}
	
	interface MembershipDaoErrorLogMessage{
		String CREATE_FAILED = "Membership creation has failed!";
		String UPDATE_FAILED = "Membership modification has failed!";
		String DELETE_FAILED = "Membership deletion has failed!";
	}
	
	interface RoleDaoErrorLogMessage{
		String CREATE_FAILED = "Role creation has failed!";
		String UPDATE_FAILED = "Role modification has failed!";
		String DELETE_FAILED = "Role deletion has failed!";
	}
	
	interface UserDaoErrorLogMessage{
		String CREATE_FAILED = "User creation has failed!";
		String UPDATE_FAILED = "User modification has failed!";
		String DELETE_FAILED = "User deletion has failed!";
	}
}
