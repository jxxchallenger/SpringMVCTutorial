package app06b.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class MyFormatterRegistrar implements FormatterRegistrar {

	private String datePattern;
	
	public MyFormatterRegistrar(String datePattern) {
		super();
		this.datePattern = datePattern;
	}


	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter(datePattern));
	}

}
