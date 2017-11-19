package a3.StrategyPatternWithDifferentFactories.PaySystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesReflectionPaymentMethodFactory {

	static public Optional<PaymentMethod> getPaymentMethod() {

		try {

			Optional<String> className = getPaymenthMethodClassName();

			if (className.isPresent()) {

				Class<?> clazz = Class.forName(className.get());
				PaymentMethod method = (PaymentMethod) clazz.newInstance();
				return Optional.of(method);
			} else {
				return Optional.empty();
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	private static Optional<String> getPaymenthMethodClassName() {

		try {

			Properties paymentConfig = new Properties();
			InputStream configFile = PropertiesReflectionPaymentMethodFactory.class
					.getResourceAsStream("config.properties");

			paymentConfig.load(configFile);

			return Optional.of(paymentConfig.getProperty("paymentMethod.className"));

		} catch (IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

}
