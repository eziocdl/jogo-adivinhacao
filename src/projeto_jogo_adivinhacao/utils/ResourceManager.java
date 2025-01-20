package projeto_jogo_adivinhacao.utils;

import java.util.ResourceBundle;

public class ResourceManager {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
	
	public static String getMessage(String key) {
		return bundle.getString(key);
	}

}
