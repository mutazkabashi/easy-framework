package com.kax.common.util.reflection;
/*package com.kax.common.util.reflection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



*//**
 * Start the name of the test case class with the prefix (Test) This naming
 * convention is not required
 * 
 * @author mutaz
 * 
 *//*
public class TestJdk7Reflection {
	private Jdk7Reflection controller;
	private Request request;
	private RequestHandler handler;

	*//**
	 * Use the @Before-annotated method to instantiate Class Under test
	 * (DefaultController). This is a built-in extension point that the JUnit
	 * framework calls between test methods
	 * 
	 * @throws Exception
	 *//*
	@Before
	public void instantiate() throws Exception {
		controller = new DefaultController();
	    request = new SampleRequest(); 
		handler = new SampleHandler();
		controller.addHandler(request, handler);
	}

	@Test
	public void testMethod() {
        *//**
         * Use a �best practice� by throwing an exception for test code that has not yet been implemented. 
         * This prevents the test from passing and reminds you that you must implement this code.
         *//*
		throw new RuntimeException("implement me");
	}
	
	@Test
	public void testAddHandler() 
	{
	
	
	RequestHandler handler2 = controller.getHandler(request); 
	
	 * The assertSame method confirms that both references are to the same object
	 
	assertSame("Handler we set in controller should be the same handler we get", handler2, handler);
	}
	
	@Test
	public void testProcessRequest() 
	{
	
	 
	Response response = controller.processRequest(request);
	
	 * You verify that the returned Response object is not null. 
	 * This is important because you call the getClass method on the Response object
	 * It will fail with a dreaded NullPointerException if the Response object is null. 
	 * You use the assertNotNull(String, Object) signature so that if the test fails, 
	 * the error displayed is meaningful and easy to understand.
	 
	assertNotNull("Must not return a null response", response);
	
	 * compare the result of the test against the expected SampleResponse class
	 * The assertEquals method utilizes the equals method, inherited from the base Object class.
	 * To see if two different objects have the same identity, you need to provide your own 
	 * definition of identity
	 
	assertEquals("Response should be of type SampleResponse",
	SampleResponse.class, response.getClass()); 
	assertEquals(new SampleResponse(), response);  //page(39)
	}
	
	@Test 
	public void testProcessRequestAnswersErrorResponse()
	{
	SampleRequest request = new SampleRequest("testError"); //(1)
	SampleExceptionHandler handler = new SampleExceptionHandler(); //(1)
	controller.addHandler(request, handler); //(2)
	Response response = controller.processRequest(request);
	assertNotNull("Must not return a null response", response); //(3)
	assertEquals(ErrorResponse.class, response.getClass()); //(3)
	}
	
	*//**
	 * Testing methods that throw an exception (Listing 2.18) page (44)
	 * If some of our methods throws undocumented (method doesn't
	 * appear in the signature)
	 * exception (e.g RuntimeException)
	 *//*
	@Test(expected=RuntimeException.class) 
	public void testGetHandlerNotDefined() 
	{
	SampleRequest request = new SampleRequest("testNotDefined"); 
	//The following line is supposed to throw a RuntimeException
	controller.getHandler(request); 
	}
	
	@Test(expected=RuntimeException.class) 
	public void testAddRequestDuplicateName()
			{
		SampleRequest request = new SampleRequest();
		SampleHandler handler = new SampleHandler();
		
		// The following line is supposed to throw a RuntimeException
		controller.addHandler(request, handler);
			}
	*//**
	 * In (timeout) parameter you can specify your time-barrier 
	 * in terms of milliseconds, and in case the test takes more 
	 * time to execute	JUnit will mark the test as failed
	 *//*
	@Test(timeout=130)
	public void testProcessMultipleRequestsTimeout(){
		Request request; 
		Response response = new SampleResponse(); 
		RequestHandler handler = new SampleHandler();
		
		for(int i=0; i< 99999; i++) 
		{
		request = new SampleRequest(String.valueOf(i));
		controller.addHandler(request, handler); 
		response = controller.processRequest(request);
		assertNotNull(response); 
		
		 * assert that the Response we get is not an ErrorResponse
		 
		assertNotSame(ErrorResponse.class, response.getClass()); 
		}
		
	}
	
	*//**
	 * When we need to skip some test methods for some reasons
	 * we use @ignore annotation
	 *//*
	
	@Test(timeout=130)
	@Ignore(value="Ignore for now until we decide a decent time-limit") 
	public void testProcessMultipleRequestTimeout()
	{
	
	}
	
}

*/