package a3.StrategyPattern.PaySystem;

import java.util.Optional;

public class RunTimeReflectionPaymentMethodFactory {

	public static Optional<PaymentMethod> getPaymentMethod(String className) {

		try {

			Class<?> clazz = Class.forName(className);
			PaymentMethod method = (PaymentMethod) clazz.newInstance();
			return Optional.of(method);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException e) {
			return Optional.empty();
		}
	}
}
