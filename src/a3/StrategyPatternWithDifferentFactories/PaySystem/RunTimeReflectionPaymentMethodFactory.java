package a3.StrategyPatternWithDifferentFactories.PaySystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class RunTimeReflectionPaymentMethodFactory {

	public static Optional<PaymentMethod> getPaymentMethod(String className) {

		try {

			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor;

			PaymentMethod method;

			// creating class by invoking constructor with arguments by reflection
			if (clazz.getSimpleName().equals("CreditCard")) {
				// System.out.println("11111111*******************");
				constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class);

				method = (CreditCard) constructor.newInstance("John Doe", "4111111111111", "123", "01/22");
				return Optional.of(method);
			}

			constructor = clazz.getConstructor();
			method = (PaymentMethod) constructor.newInstance();
			return Optional.of(method);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
			return Optional.empty();
		}

		// try {
		//
		// Class<?> clazz = Class.forName(className);
		//
		// PaymentMethod method;
		//
		// // Note that this method propagates any exception thrown by the nullary
		// // constructor, including a checked exception. Use of this method effectively
		// // bypasses the compile-time exception checking that would otherwise be
		// // performed by the compiler. The Constructor.newInstance method avoids this
		// // problem by wrapping any exception thrown by the constructor in a (checked)
		// // InvocationTargetException.
		// method = (PaymentMethod) clazz.newInstance();
		// return Optional.of(method);
		//
		// } catch (ClassNotFoundException | InstantiationException |
		// IllegalAccessException | ClassCastException
		// | IllegalArgumentException | InvocationTargetException |
		// NoSuchMethodException | SecurityException e) {
		//
		// e.printStackTrace();
		// return Optional.empty();
		// }
	}
}
