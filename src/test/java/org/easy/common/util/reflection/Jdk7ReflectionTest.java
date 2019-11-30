package org.easy.common.util.reflection;

import static org.junit.Assert.*;

import org.easy.common.utils.reflection.Jdk7Reflection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Jdk7ReflectionTest {

	Jdk7Reflection jdk7Ref = new Jdk7Reflection();

	/*
	 * @Mock IContainer coffeeContainer;
	 * 
	 * @Mock IContainer waterContainer;
	 */

	@Before
	public void setUp() {
		// coffeeMachine = new CoffeeMachine(coffeeContainer, waterContainer);
	}

	@After
	public void tearDown() {
		/*
		 * coffeeContainer = null; waterContainer = null; coffeeMachine = null;
		 */
	}

	@Test
	public void testGetMethod() {
		//fail("Not yet implemented");
	}

}
