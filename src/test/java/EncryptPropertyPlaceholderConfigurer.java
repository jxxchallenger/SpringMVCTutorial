import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

	private static final String USER_NAME = "jdbc.username";
	
	private static final String PASSWORD = "jdbc.password";
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		
		if(isEncryptProp(propertyName)){
			//return ;
		}
		
		return super.convertProperty(propertyName, propertyValue);
	}
	
	private boolean isEncryptProp(String propertyName){
		
		if(USER_NAME.equals(propertyName) || PASSWORD.equals(propertyName)){
			return true;
		}
		else{
			return false;
		}
	}

}
