package j8.Annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import j8.Annotations.ControllObject.Colors;

public class PreJ8AnnotationsExampleTestLab {

	public static void main(String[] args) {

		try {

			Class cl = Class.forName("j8.Annotations.Cookies");

			if (!cl.isAnnotationPresent(ControllObject.class)) {

				System.out.println("no " + ControllObject.class.getSimpleName() + " annotation");

			} else {

				System.out.println("present annotation - " + cl.getAnnotation(ControllObject.class));
			}
			if (!cl.isAnnotationPresent(Override.class)) {

				System.out.println("absent annotation - " + Override.class.getSimpleName() + " annotation");

			} else {

				System.out.println("class annotated: name - " + cl.getAnnotation(Override.class));
			}

			Annotation[] annotations = cl.getAnnotations();
			for (Annotation an : annotations) {

				System.out.println("Annotation - " + an);
			}

			Method[] methods = cl.getMethods();
			for (Method md : methods) {

				System.out.println("Method name: " + md.getName());

				annotations = md.getAnnotations();
				for (Annotation an : annotations) {
					System.out.println("Annotation type: " + an.annotationType());

				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface ControllObject {

	String name();

	String surname() default "mango";

	Colors color();

	enum Colors {
		RED, GREEN, WHITE
	}

}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface CreationDate {

	int day();

	int month();

	int year();

}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface VersionNumber {

	int version() default 1;

}

@VersionNumber(version = 2)
@CreationDate(day = 5, month = 10, year = 2001)
@ControllObject(name = "SW:Chocolate", color = Colors.GREEN)
class Cookies {

	@StartObject
	public void createCookie() {

	}

	@StopObject
	public void eatCookie() {

	}

}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface StartObject {
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface StopObject {
}
