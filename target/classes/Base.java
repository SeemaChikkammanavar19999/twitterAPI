package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;




public class Base {
  
	  public Properties prop;
	public void Initial() throws IOException {
	    prop= new Properties();
	    FileInputStream fis = new FileInputStream("C:\\Users\\Qualitest\\eclipse-workspace\\Tweet\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fis);
	    }
	
	

  
//  public static org.apache.logging.log4j.Logger log1;
//
//
//  public void Bsuite() throws FileNotFoundException, IOException {
//
//  String log4jConfigFile=("C:\\Users\\Qualitest\\eclipse-workspace\\Tweet\\src\\main\\java\\Resources\\log4j2.xml");
//
//  ConfigurationSource source=new ConfigurationSource(new FileInputStream(log4jConfigFile));
//
//  Configurator.initialize(null,source);
//
//  log1=LogManager.getLogger(Base.class.getName());
//
//   
//
//  }
}
