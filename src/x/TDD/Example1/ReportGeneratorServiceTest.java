package x.TDD.Example1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//https://mvnrepository.com
//http://search.maven.org/
//@RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorServiceTest {

	// https://examples.javacodegeeks.com/core-java/mockito/test-driven-development-mockito/
	// @InjectMocks mark a field on which injection should be performed. It allows
	// shorthand mock and spy injection. Mockito will try to inject mocks only
	// either by constructor injection, setter injection, or property injection in
	// order and as described below. If any of the following strategy fail, then
	// Mockito won’t report failure i.e. you will have to provide dependencies
	// yourself.
	//
	// Constructor injection: the biggest constructor is chosen, then arguments are
	// resolved with mocks declared in the test only. If the object is successfully
	// created with the constructor, then Mockito won’t try the other strategies.
	// Mockito has decided not to corrupt an object if it has a parametered
	// constructor. If arguments can not be found, then null is passed. If
	// non-mockable types are wanted, then constructor injection won’t happen. In
	// these cases, you will have to satisfy dependencies yourself.
	//
	// Property setter injection: mocks will first be resolved by type (if a single
	// type matches injection will happen regardless of the name), then, if there
	// are several property of the same type, by the match of the property name and
	// the mock name. If you have properties with the same type (or same erasure),
	// it’s better to name all @Mock annotated fields with the matching properties,
	// otherwise Mockito might get confused and injection won’t happen. If
	// @InjectMocks instance wasn’t initialized before and have a no-arg
	// constructor, then it will be initialized with this constructor.
	//
	// Field injection: mocks will first be resolved by type (if a single type
	// matches injection will happen regardless of the name), then, if there is
	// several property of the same type, by the match of the field name and the
	// mock name. If you have fields with the same type (or same erasure), it’s
	// better to name all @Mock annotated fields with the matching fields, otherwise
	// Mockito might get confused and injection won’t happen. If @InjectMocks
	// instance wasn’t initialized before and have a no-arg constructor, then it
	// will be initialized with this constructor.
	@InjectMocks
	private ReportGeneratorService reportGeneratorService;

	// Now we will mock the interface using @Mock annotation:
	@Mock
	private ReportGenerator reportGenerator;

	// Now we will define the argument captor on report entity:
	// The ArgumentCaptor class is used to capture argument values for further
	// assertions. Mockito verifies argument values in natural java style: by using
	// an equals() method. This is also the recommended way of matching arguments
	// because it makes tests clean & simple. In some situations though, it is
	// helpful to assert on certain arguments after the actual verification
	@Captor
	private ArgumentCaptor<ReportEntity> reportCaptor;

	// for init - on test @RunWith(MockitoJUnitRunner.class)
	// initMocks() initializes objects annotated with Mockito annotations for given
	// test class
	// @Before
	// public void setUp() {
	// MockitoAnnotations.initMocks(this);
	// }

	@Test

	public void testReport() {

		LocalDate startDate = LocalDate.of(2016, 11, 25);
		LocalDate endDate = LocalDate.of(9999, 12, 31);
		String reportContent = "Report Content";
		reportGeneratorService.generateReport(startDate, endDate, reportContent.getBytes());

		Mockito.verify(reportGenerator).generateReport(reportCaptor.capture());

		ReportEntity report = reportCaptor.getValue();

		assertEquals(2016, report.getStartDate().getYear());
		assertEquals(Month.NOVEMBER, report.getStartDate().getMonth());
		assertEquals(25, report.getStartDate().getDayOfMonth());

		assertEquals(9999, report.getEndDate().getYear());
		assertEquals(Month.valueOf("DECEMBER"), report.getEndDate().getMonth());
		assertEquals(31, report.getEndDate().getDayOfMonth());

		assertEquals("Report Content", new String(report.getContent()));
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}
}
//http://www.vogella.com/tutorials/Mockito/article.html#prerequisites

// 2.2. Mock object generation
// You can create mock objects manually (via code) or use a mock framework to
// simulate these classes. Mock frameworks allow you to create mock objects at
// runtime and define their behavior.
//
// A mock object is a dummy implementation for an interface or a class in which
// you define the output of certain method calls. Mock objects are configured to
// perform a certain behavior during a test. They typical record the interaction
// with the system and test can validate that.
//
// Test doubles can be passed to other objects which are tested. Your tests can
// validate that the class reacts correctly during tests. For example, you can
// validate if certain methods on the mock object were called. This helps to
// ensure that you only test the class while running tests and that your tests
// are not affected by any side effects.
//
// Mock objects typically require less code to configure and should therefore be
// preferred.
// The classical example for a mock object is a data provider. In production an
// implementation to connect to the real data source is used. But for testing a
// mock object simulates the data source and ensures that the test conditions
// are always the same.
//
// These mock objects can be provided to the class which is tested. Therefore,
// the class to be tested should avoid any hard dependency on external data.
//
// 3. Adding Mockito as dependencies to a project
// 3.1. Using Gradle for a Java project
// If you use Gradle in a Java project, add the following dependency to the
// Gradle build file.
//
// repositories { jcenter() }
// dependencies { testCompile 'org.mockito:mockito-core:2.7.22' }
// 3.2. Using Gradle for an Android project
// Add the following dependency to the Gradle build file:
//
// dependencies {
// // ... more entries
// testCompile 'junit:junit:4.12'
//
// // required if you want to use Mockito for unit tests
// testCompile 'org.mockito:mockito-core:2.7.22'
// // required if you want to use Mockito for Android tests
// androidTestCompile 'org.mockito:mockito-android:2.7.22'
// }
// 3.3. Using Maven
// Maven users can declare a dependency. Search for g:"org.mockito",
// a:"mockito-core" via the http://search.maven.org website to find the correct
// pom entry
// 4. Using the Mockito API
// 4.1. Creating mock objects with Mockito
// Mockito provides several methods to create mock objects:
//
// Using the static mock() method.
//
// Using the @Mock annotation.
//
// If you use the @Mock annotation, you must trigger the creation of annotated
// objects. The MockitoRule allows this. It invokes the static method
// MockitoAnnotations.initMocks(this) to populate the annotated fields.
// Alternatively you can use @RunWith(MockitoJUnitRunner.class).
//
// The usage of the @Mock annotation and the MockitoRule rule is demonstrated by
// the following example.
//
// import static org.mockito.Mockito.*;
//
// public class MockitoTest {
//
// @Mock
// MyDatabase databaseMock;
//
// @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
//
// @Test
// public void testQuery() {
// ClassToTest t = new ClassToTest(databaseMock);
// boolean check = t.query("* from t");
// assertTrue(check);
// verify(databaseMock).query("* from t");
// }
// }
// Tells Mockito to mock the databaseMock instance
// Tells Mockito to create the mocks based on the @Mock annotation
// Instantiates the class under test using the created mock
// Executes some code of the class under test
// Asserts that the method call returned true
// Verify that the query method was called on the MyDatabase mock
// Static imports
// By adding the org.mockito.Mockito.*; static import, you can use methods like
// mock() directly in your tests. Static imports allow you to call static
// members, i.e., methods and fields of a class directly without specifying the
// class.
//
// Using static imports greatly improves the readability of your test code, you
// should use it.
//
// 4.2. Configuring mocks
// Mockito allows to configure the return values of its mocks via a fluent API.
// Unspecified method calls return "empty" values:
//
// null for objects
//
// 0 for numbers
//
// false for boolean
//
// empty collections for collections
//
// ...
//
// The following assert statements are only for demonstration purposes, a real
// test would use the mocks to unit test another functionality.
//
// 4.2.1. "when thenReturn" and "when thenThrow
// Mocks can return different values depending on arguments passed into a
// method. The when(....).thenReturn(....) method chain is used to specify a a
// return value for a method call with pre-defined parameters.
//
// whenThenReturn10
// You also can use methods like anyString or anyInt to define that dependent on
// the input type a certain value should be returned.
//
// If you specify more than one value, they are returned in the order of
// specification, until the last one is used. Afterwards the last specified
// value is returned.
//
// The following demonstrates the usage of when(...).thenReturn(...).
//
// import static org.mockito.Mockito.*;
// import static org.junit.Assert.*;
//
// @Test
// public void test1() {
// // create mock
// MyClass test = mock(MyClass.class);
//
// // define return value for method getUniqueId()
// when(test.getUniqueId()).thenReturn(43);
//
// // use mock in test....
// assertEquals(test.getUniqueId(), 43);
// }
//
//
// // demonstrates the return of multiple values
// @Test
// public void testMoreThanOneReturnValue() {
// Iterator<String> i= mock(Iterator.class);
// when(i.next()).thenReturn("Mockito").thenReturn("rocks");
// String result= i.next()+" "+i.next();
// //assert
// assertEquals("Mockito rocks", result);
// }
//
// // this test demonstrates how to return values based on the input
// @Test
// public void testReturnValueDependentOnMethodParameter() {
// Comparable<String> c= mock(Comparable.class);
// when(c.compareTo("Mockito")).thenReturn(1);
// when(c.compareTo("Eclipse")).thenReturn(2);
// //assert
// assertEquals(1, c.compareTo("Mockito"));
// }
//
// // this test demonstrates how to return values independent of the input value
//
// @Test
// public void testReturnValueInDependentOnMethodParameter() {
// Comparable<Integer> c= mock(Comparable.class);
// when(c.compareTo(anyInt())).thenReturn(-1);
// //assert
// assertEquals(-1, c.compareTo(9));
// }
//
// // return a value based on the type of the provide parameter
//
// @Test
// public void testReturnValueInDependentOnMethodParameter2() {
// Comparable<Todo> c= mock(Comparable.class);
// when(c.compareTo(isA(Todo.class))).thenReturn(0);
// //assert
// assertEquals(0, c.compareTo(new Todo(1)));
// }
// The when(...).thenReturn(...) method chain can be used to throw an exception.
//
// Properties properties = mock(Properties.class);
//
// when(properties.get(”Anddroid”)).thenThrow(new
// IllegalArgumentException(...));
//
// try {
// properties.get(”Anddroid”);
// fail(”Anddroid is misspelled”);
// } catch (IllegalArgumentException ex) {
// // good!
// }
// 4.2.2. "doReturn when" and "doThrow when"
// The doReturn(...).when(...).methodCall call chain works similar to
// when(...).thenReturn(...). It is useful for mocking methods which give an
// exception during a call, e.g., if you use use functionality like Wrapping
// Java objects with Spy.
//
// doReturnWhen.java
// The doThrow variant can be used for methods which return void to throw an
// exception. This usage is demonstrated by the following code snippet.
//
// Properties properties = new Properties();
//
// Properties spyProperties = spy(properties);
//
// doReturn(“42”).when(spyProperties).get(”shoeSize”);
//
// String value = spyProperties.get(”shoeSize”);
//
// assertEquals(”42”, value);
// 4.3. Wrapping Java objects with Spy
// @Spy or the spy() method can be used to wrap a real object. Every call,
// unless specified otherwise, is delegated to the object.
//
// import static org.mockito.Mockito.*;
//
// @Test
// public void testLinkedListSpyWrong() {
// // Lets mock a LinkedList
// List<String> list = new LinkedList<>();
// List<String> spy = spy(list);
//
// // this does not work
// // real method is called so spy.get(0)
// // throws IndexOutOfBoundsException (list is still empty)
// when(spy.get(0)).thenReturn("foo");
//
// assertEquals("foo", spy.get(0));
// }
//
// @Test
// public void testLinkedListSpyCorrect() {
// // Lets mock a LinkedList
// List<String> list = new LinkedList<>();
// List<String> spy = spy(list);
//
// // You have to use doReturn() for stubbing
// doReturn("foo").when(spy).get(0);
//
// assertEquals("foo", spy.get(0));
// }
// 4.4. Verify the calls on the mock objects
// Mockito keeps track of all the method calls and their parameters to the mock
// object. You can use the verify() method on the mock object to verify that the
// specified conditions are met. For example, you can verify that a method has
// been called with certain parameters. This kind of testing is sometimes called
// behavior testing. Behavior testing does not check the result of a method
// call, but it checks that a method is called with the right parameters.
//
// import static org.mockito.Mockito.*;
//
// @Test
// public void testVerify() {
// // create and configure mock
// MyClass test = Mockito.mock(MyClass.class);
// when(test.getUniqueId()).thenReturn(43);
//
//
// // call method testing on the mock with parameter 12
// test.testing(12);
// test.getUniqueId();
// test.getUniqueId();
//
//
// // now check if method testing was called with the parameter 12
// verify(test).testing(ArgumentMatchers.eq(12));
//
// // was the method called twice?
// verify(test, times(2)).getUniqueId();
//
// // other alternatives for verifiying the number of method calls for a method
// verify(test, never()).someMethod("never called");
// verify(test, atLeastOnce()).someMethod("called at least once");
// verify(test, atLeast(2)).someMethod("called at least twice");
// verify(test, times(5)).someMethod("called five times");
// verify(test, atMost(3)).someMethod("called at most 3 times");
// // This let's you check that no other methods where called on this object.
// // You call it after you have verified the expected method calls.
// verifyNoMoreInteractions(test);
// }
// In case you do not care about the value, use the anyX, e.g., anyInt,
// anyString(), or any(YourClass.class) methods.
//
// 4.5. Using @InjectMocks for dependency injection via Mockito
// You also have the @InjectMocks annotation which tries to do constructor,
// method or field dependency injection based on the type. For example, assume
// that you have the following class.
//
// public class ArticleManager {
// private User user;
// private ArticleDatabase database;
//
// public ArticleManager(User user, ArticleDatabase database) {
// super();
// this.user = user;
// this.database = database;
// }
//
// public void initialize() {
// database.addListener(new ArticleListener());
// }
// }
// This class can be constructed via Mockito and its dependencies can be
// fulfilled with mock objects as demonstrated by the following code snippet.
//
// @RunWith(MockitoJUnitRunner.class)
// public class ArticleManagerTest {
//
// @Mock ArticleCalculator calculator;
// @Mock ArticleDatabase database;
// @Mock User user;
//
// @Spy private UserProvider userProvider = new ConsumerUserProvider();
//
// @InjectMocks private ArticleManager manager;
//
// @Test public void shouldDoSomething() {
// // calls addListener with an instance of ArticleListener
// manager.initialize();
//
// // validate that addListener was called
// verify(database).addListener(any(ArticleListener.class));
// }
// }
// creates an instance of ArticleManager and injects the mocks into it
// Mockito can inject mocks either via constructor injection, setter injection,
// or property injection and in this order. So if ArticleManager would have a
// constructor that would only take User and setters for both fields, only the
// mock for User would be injected.
//
// 4.6. Capturing the arguments
// The ArgumentCaptor class allows to access the arguments of method calls
// during the verification. This allows to capture these arguments of method
// calls and to use them for tests.
//
// To run this example you need to add hamcrest-library to your project.
//
// import static org.hamcrest.Matchers.hasItem;
// import static org.junit.Assert.assertThat;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.verify;
//
// import java.util.Arrays;
// import java.util.List;
//
// import org.junit.Rule;
// import org.junit.Test;
// import org.mockito.ArgumentCaptor;
// import org.mockito.Captor;
// import org.mockito.junit.MockitoJUnit;
// import org.mockito.junit.MockitoRule;
//
//
// public class MockitoTests {
//
// @Rule
// public MockitoRule rule = MockitoJUnit.rule();
//
// @Captor
// private ArgumentCaptor<List<String>> captor;
//
//
// @Test
// public final void shouldContainCertainListItem() {
// List<String> asList = Arrays.asList("someElement_test", "someElement");
// final List<String> mockedList = mock(List.class);
// mockedList.addAll(asList);
//
// verify(mockedList).addAll(captor.capture());
// final List<String> capturedArgument = captor.getValue();
// assertThat(capturedArgument, hasItem("someElement"));
// }
// }
// 4.7. Using Answers for complex mocks
// It is possible to define a Answer object for complex results. While
// thenReturn returns a predefined value every time, with answers you can
// calculate a response based on the arguments given to your stubbed method.
// This can be useful if your stubbed method is supposed to call a function on
// one of the arguments or if your method is supposed to return the first
// argument to allow method chaining. There exists a static method for the
// latter. Also note that there a different ways to configure an answer:
//
// import static org.mockito.AdditionalAnswers.returnsFirstArg;
//
// @Test
// public final void answerTest() {
// // with doAnswer():
// doAnswer(returnsFirstArg()).when(list).add(anyString());
// // with thenAnswer():
// when(list.add(anyString())).thenAnswer(returnsFirstArg());
// // with then() alias:
// when(list.add(anyString())).then(returnsFirstArg());
// }
// Or if you need to do a callback on your argument:
//
// @Test
// public final void callbackTest() {
// ApiService service = mock(ApiService.class);
// when(service.login(any(Callback.class))).thenAnswer(i -> {
// Callback callback = i.getArgument(0);
// callback.notify("Success");
// return null;
// });
// }
// It is even possible to mock a persistence service like an DAO, but you should
// consider creating a fake class instead of a mock if your Answers become too
// complex.
//
// List<User> userMap = new ArrayList<>();
// UserDao dao = mock(UserDao.class);
// when(dao.save(any(User.class))).thenAnswer(i -> {
// User user = i.getArgument(0);
// userMap.add(user.getId(), user);
// return null;
// });
// when(dao.find(any(Integer.class))).thenAnswer(i -> {
// int id = i.getArgument(0);
// return userMap.get(id);
// });
// 4.8. Mocking final classes
// Since Mockito v2 it is possible to mock final classes. This feature is
// incubating and is deactivated by default. To activate the mocking of final
// classes create the file org.mockito.plugins.MockMaker in either
// src/test/resources/mockito-extensions/ or src/mockito-extensions/. Add this
// line to the file: mock-maker-inline. With this modification we now can mock a
// final class.
//
// final class FinalClass {
// public final String finalMethod() { return "something"; }
// }
//
// @Test
// public final void mockFinalClassTest() {
// FinalClass instance = new FinalClass();
//
// FinalClass mock = mock(FinalClass.class);
// when(mock.finalMethod()).thenReturn("that other thing");
//
// assertNotEquals(mock.finalMethod(), instance.finalMethod());
// }
// 4.9. Clean test code with the help of the strict stubs rule
// The strict stubs rule helps you to keep your test code clean and checks for
// common oversights. It adds the following:
//
// test fails early when a stubbed method gets called with different arguments
// than what it was configured for (with PotentialStubbingProblem exception).
//
// test fails when a stubbed method isn’t called (with
// UnnecessaryStubbingException exception).
//
// org.mockito.Mockito.verifyNoMoreInteractions(Object) also verifies that all
// stubbed methods have been called during the test
//
// @Test
// public void withoutStrictStubsTest() throws Exception {
// DeepThought deepThought = mock(DeepThought.class);
//
// when(deepThought.getAnswerFor("Ultimate Question of Life, The Universe, and
// Everything")).thenReturn(42);
// when(deepThought.otherMethod("some mundane thing")).thenReturn(null);
//
// System.out.println(deepThought.getAnswerFor("Six by nine"));
//
// assertEquals(42, deepThought.getAnswerFor("Ultimate Question of Life, The
// Universe, and Everything"));
// verify(deepThought, times(1)).getAnswerFor("Ultimate Question of Life, The
// Universe, and Everything");
// }
// // activate the strict subs rule
// @Rule public MockitoRule rule =
// MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
//
// @Test
// public void withStrictStubsTest() throws Exception {
// DeepThought deepThought = mock(DeepThought.class);
//
// when(deepThought.getAnswerFor("Ultimate Question of Life, The Universe, and
// Everything")).thenReturn(42);
// // this fails now with an UnnecessaryStubbingException since it is never
// called in the test
// when(deepThought.otherMethod("some mundane thing")).thenReturn(null);
//
// // this will now throw a PotentialStubbingProblem Exception since we usually
// don't want to call methods on mocks without configured behavior
// deepThought.someMethod();
//
// assertEquals(42, deepThought.getAnswerFor("Ultimate Question of Life, The
// Universe, and Everything"));
// // verifyNoMoreInteractions now automatically verifies that all stubbed
// methods have been called as well
// verifyNoMoreInteractions(deepThought);
// }
// 4.10. Limitations
// Mockito has certain limitations. For example, you cannot mock static methods
// and private methods.
//
// See FAQ for Mockito limitations for the details
//
// 4.11. Behavior testing vrs. state testing
// Mockito puts a focus on behavior testing, vrs. result testing. This is not
// always correct, for example, if you are testing a sort algorithm, you should
// test the result not the internal behavior.
//
// // state testing
// testSort() {
// testList = [1, 7, 3, 8, 2]
// MySorter.sort(testList)
//
// assert testList equals [1, 2, 3, 7, 8]
// }
//
//
// // incorrect would be behavior testing
// // the following tests internal of the implementation
// testSort() {
// testList = [1, 7, 3, 8, 2]
// MySorter.sort(testList)
//
// assert that compare(1, 2) was called once
// assert that compare(1, 3) was not called
// assert that compare(2, 3) was called once
// ....
// }
// 5. Exercise: Write an instrumented unit test using Mockito
// 5.1. Create Application under tests on Android
// Create an Android application with the package name
// com.vogella.android.testing.mockito.contextmock. Add a Util class with a
// static method which allows to create an intent with certain parameters as in
// the following example.
//
// package com.vogella.android.testing.mockito.contextmock;
//
// import android.content.Context;
// import android.content.Intent;
//
// public class Util {
//
// public static Intent createQuery(Context context, String query, String value)
// {
// // Reuse MainActivity for simplification
// Intent i = new Intent(context, MainActivity.class);
// i.putExtra("QUERY", query);
// i.putExtra("VALUE", value);
// return i;
// }
// }
// 5.2. Add the Mockito dependency to the app/build.gradle file
// dependencies {
// // ... more entries
// testCompile 'junit:junit:4.12'
//
// // required if you want to use Mockito for unit tests
// testCompile 'org.mockito:mockito-core:2.7.22'
// // required if you want to use Mockito for Android tests
// androidTestCompile 'org.mockito:mockito-android:2.7.22'
// }
// 5.3. Create test
// Create a new unit test running on Android using Mockito in the androidTest
// folder. This test should check if the intent contains the correct extras. For
// this you mock the Context object with Mockito.
//
// package com.vogella.android.testing.mockito.contextmock;
//
// import android.content.Context;
// import android.content.Intent;
// import android.os.Bundle;
// import android.support.test.runner.AndroidJUnit4;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
//
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
// import static org.mockito.Mockito.mock;
//
// @RunWith(AndroidJUnit4.class)
// public class UtilTest2 {
//
// @Test
// public void shouldContainTheCorrectExtras() throws Exception {
// Context context = mock(Context.class);
// Intent intent = Util.createQuery(context, "query", "value");
// assertNotNull(intent);
// Bundle extras = intent.getExtras();
// assertNotNull(extras);
// assertEquals("query", extras.getString("QUERY"));
// assertEquals("value", extras.getString("VALUE"));
// }
// }
// 6. Exercise: Creating mock objects using Mockito
// 6.1. Target
// Create an API, which can be mocked and use Mockito to do the job.
//
// 6.2. Create a sample Twitter API
// Implement a TwitterClient, which works with ITweet instances. But imagine
// these ITweet instances are pretty cumbersome to get, e.g., by using a complex
// service, which would have to be started.
//
// public interface ITweet {
//
// String getMessage();
// }
// public class TwitterClient {
//
// public void sendTweet(ITweet tweet) {
// String message = tweet.getMessage();
//
// // send the message to Twitter
// }
// }
// 6.3. Mocking ITweet instances
// In order to avoid starting up a complex service to get ITweet instances, they
// can also be mocked by Mockito.
//
// @Test
// public void testSendingTweet() {
// TwitterClient twitterClient = new TwitterClient();
//
// ITweet iTweet = mock(ITweet.class);
//
// when(iTweet.getMessage()).thenReturn("Using mockito is great");
//
// twitterClient.sendTweet(iTweet);
// }
// Now the TwitterClient can make use of a mocked ITweet instance and will get
// "Using Mockito is great" as message when calling getMessage() on the mocked
// ITweet.
//
// 6.4. Verify method invocation
// Ensure that getMessage() is at least called once.
//
// @Test
// public void testSendingTweet() {
// TwitterClient twitterClient = new TwitterClient();
//
// ITweet iTweet = mock(ITweet.class);
//
// when(iTweet.getMessage()).thenReturn("Using mockito is great");
//
// twitterClient.sendTweet(iTweet);
//
// verify(iTweet, atLeastOnce()).getMessage();
// }
// 6.5. Validate
// Run the test and validate that it is successful.
//
// 7. Using PowerMock with Mockito
// 7.1. Powermock for mocking static methods
// Mockito cannot mock static methods. For this you can use Powermock. PowerMock
// provides a class called "PowerMockito" for creating mock/object/class and
// initiating verification, and expectations, everything else you can still use
// Mockito to setup and verify expectation (e.g. times(), anyInt()).
//
// import java.net.InetAddress;
// import java.net.UnknownHostException;
//
// public final class NetworkReader {
// public static String getLocalHostname() {
// String hostname = "";
// try {
// InetAddress addr = InetAddress.getLocalHost();
// // Get hostname
// hostname = addr.getHostName();
// } catch ( UnknownHostException e ) {
// }
// return hostname;
// }
// }
// To write a test which mocks away the NetworkReader as dependency you can use
// the following snippet.
//
// import org.junit.runner.RunWith;
// import org.powermock.core.classloader.annotations.PrepareForTest;
//
// @RunWith( PowerMockRunner.class )
// @PrepareForTest( NetworkReader.class )
// public class MyTest {
//
// // Find the tests here
//
// @Test
// public void testSomething() {
// mockStatic( NetworkUtil.class );
// when( NetworkReader.getLocalHostname() ).andReturn( "localhost" );
//
// // now test the class which uses NetworkReader
// }
// 8. Using a wrapper instead of Powermock
// Sometimes you can also use a wrapper around a static method, which can be
// mocked with Mockito.
//
// class FooWraper {
// void someMethod() {
// Foo.someStaticMethod()
// }
// }
// 8.1. Learn more about Powermock

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Mockito
// http://www.baeldung.com/mockito-annotations
// Mockito – Using Spies
// http://www.baeldung.com/mockito-spy
// Mockito vs EasyMock vs JMockit
// http://www.baeldung.com/mockito-vs-easymock-vs-jmockit
// Injecting Mockito Mocks into Spring Beans
// http://www.baeldung.com/injecting-mocks-in-spring
// all
// http://www.baeldung.com/category/mockito/

// 2. Enable Mockito Annotations
// First – let’s see how to enable the use of annotations with Mockito tests.
//
// In order for these annotations to be enabled, we’ll need to annotate the
// JUnit test with a runner – MockitoJUnitRunner as in the following example:
//
// @RunWith(MockitoJUnitRunner.class)
// public class MockitoAnnotationTest {
// ...
// }
// Alternatively, we can enable these annotations programmatically as well, by
// invoking MockitoAnnotations.initMocks() as in the following example:
//
// @Before
// public void init() {
// MockitoAnnotations.initMocks(this);
// }
// 3. @Mock Annotation
// The most used widely used annotation in Mockito is @Mock. We can use @Mock to
// create and inject mocked instances without having to call Mockito.mock
// manually.
//
// In the following example – we’ll create a mocked ArrayList with the manual
// way without using @Mock annotation:
//
// @Test
// public void whenNotUseMockAnnotation_thenCorrect() {
// List mockList = Mockito.mock(ArrayList.class);
//
// mockList.add("one");
// Mockito.verify(mockList).add("one");
// assertEquals(0, mockList.size());
//
// Mockito.when(mockList.size()).thenReturn(100);
// assertEquals(100, mockList.size());
// }
// And now we’ll do the same but we’ll inject the mock using the @Mock
// annotation:
//
// @Mock
// List<String> mockedList;
//
// @Test
// public void whenUseMockAnnotation_thenMockIsInjected() {
// mockedList.add("one");
// Mockito.verify(mockedList).add("one");
// assertEquals(0, mockedList.size());
//
// Mockito.when(mockedList.size()).thenReturn(100);
// assertEquals(100, mockedList.size());
// }
// Note how – in both examples, we’re interacting with the mock and verifying
// some of these interactions – just to make sure that the mock is behaving
// correctly.
//
// 4. @Spy Annotation
// Now – let’s see how to use @Spy annotation to spy on an existing instance.
//
// In the following example – we create a spy of a List with the old way without
// using @Spy annotation:
//
// @Test
// public void whenNotUseSpyAnnotation_thenCorrect() {
// List<String> spyList = Mockito.spy(new ArrayList<String>());
//
// spyList.add("one");
// spyList.add("two");
//
// Mockito.verify(spyList).add("one");
// Mockito.verify(spyList).add("two");
//
// assertEquals(2, spyList.size());
//
// Mockito.doReturn(100).when(spyList).size();
// assertEquals(100, spyList.size());
// }
// Let’s now do the same – spy on the list – but do so using the @Spy
// annotation:
//
// @Spy
// List<String> spiedList = new ArrayList<String>();
//
// @Test
// public void whenUseSpyAnnotation_thenSpyIsInjected() {
// spiedList.add("one");
// spiedList.add("two");
//
// Mockito.verify(spiedList).add("one");
// Mockito.verify(spiedList).add("two");
//
// assertEquals(2, spiedList.size());
//
// Mockito.doReturn(100).when(spiedList).size();
// assertEquals(100, spiedList.size());
// }
// Note how, as before – we’re interacting with the spy here to make sure that
// it behaves correctly. In this example we:
//
// Used the real method spiedList.add() to add elements to the spiedList.
// Stubbed the method spiedList.size() to return 100 instead of 2 using
// Mockito.doReturn().
// 5. @Captor Annotation
// Next – let’s see how to use the @Captor annotation to create an
// ArgumentCaptor instance.
//
// In the following example – we create an ArgumentCaptor with the old way
// without using @Captor annotation:
//
// @Test
// public void whenNotUseCaptorAnnotation_thenCorrect() {
// List mockList = Mockito.mock(List.class);
// ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
//
// mockList.add("one");
// Mockito.verify(mockList).add(arg.capture());
//
// assertEquals("one", arg.getValue());
// }
// Let’s now make use of @Captor for the same purpose – to create an
// ArgumentCaptor instance:
//
// @Mock
// List mockedList;
//
// @Captor
// ArgumentCaptor argCaptor;
//
// @Test
// public void whenUseCaptorAnnotation_thenTheSam() {
// mockedList.add("one");
// Mockito.verify(mockedList).add(argCaptor.capture());
//
// assertEquals("one", argCaptor.getValue());
// }
// Notice how the test becomes simpler and more readable when we take out the
// configuration logic.
//
// 6. @InjectMocks Annotation
// Now – let’s discuss how to use @InjectMocks annotation – to inject mock
// fields into the tested object automatically.
//
// In the following example – we use @InjectMocks to inject the mock wordMap
// into the MyDictionary dic:
//
// @Mock
// Map<String, String> wordMap;
//
// @InjectMocks
// MyDictionary dic = new MyDictionary();
//
// @Test
// public void whenUseInjectMocksAnnotation_thenCorrect() {
// Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
//
// assertEquals("aMeaning", dic.getMeaning("aWord"));
// }
// And here is the class MyDictionary:
//
// public class MyDictionary {
// Map<String, String> wordMap;
//
// public MyDictionary() {
// wordMap = new HashMap<String, String>();
// }
// public void add(final String word, final String meaning) {
// wordMap.put(word, meaning);
// }
// public String getMeaning(final String word) {
// return wordMap.get(word);
// }
// }
// 7. Notes
// Finally – here are some notes about Mockito annotations:
//
// Use annotation to minimize repetitive mock creation code
// Use annotation to make the test more readable
// Use @InjectMocks to inject both @Spy and @Mock instances
