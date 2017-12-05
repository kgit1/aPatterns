package j8.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class J8AnnotationsExmple {

	public static void main(String[] args) {

		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);

		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);

		Hints[] hints2 = Person.class.getAnnotationsByType(Hints.class);
		System.out.println(hints2.length);

	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
	Hint[] value();
}

@Repeatable(Hints.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Hint {
	String value();
}

// old way
// @Hints({ @Hint("hint1"), @Hint("hint2") })
// class Person {
// }

// new way
@Hint("hint1")
@Hint("hint2")
class Person {
}

@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@interface MyAnnotation {
}