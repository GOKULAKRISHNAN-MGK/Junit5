package io.mgk;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
//import org.junit.jupiter.api.TestInstance;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	MathUtils mathUtils;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	@AfterAll
	static void afterAllInit() {
		System.out.println("This runs after all the methods");
	}
	
	@BeforeEach
	void Init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+"with tag "+testInfo.getTags());
	}
	
	@AfterEach
	void Cleanup() {
		System.out.println("Cleaning up...");
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("Testing add method") void testAdd() { int expected = 2; int
	 * Actual = mathUtils.Add(1, 1); assertEquals(expected,
	 * Actual,"the add method should add two numbers"); }
	 */
	@Nested
	@Tag("Math")
	@DisplayName("Add Method")
	class AddTest {
		
		@Test
		@DisplayName("Adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, mathUtils.Add(1, 1),"Should return the right sum");
		}
		
		@Test
		@DisplayName("Adding two negative numbers")
		void testAddNegative() {
			assertEquals(-2, mathUtils.Add(-1, -1),"Should return the right sum");
		}
	}
	
	@Test
	@Tag("Math")
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Testing Divide method")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.Divide(1,0),"divide by zero should throw");
	}
	
	@Test
	@Tag("Circle")
	@DisplayName("Testing ComputeCircleArea method")
	void testComputeCircleArea() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),() -> "Should return right area");
	}
	
	@RepeatedTest(3)
	@Tag("Math")
	@DisplayName("Mutliply Method")
	void testMultiply(RepetitionInfo repetitionInfo) {
		assertAll(
				() -> assertEquals(2,mathUtils.Multiply(1, 2)),
				() -> assertEquals(0,mathUtils.Multiply(0, 1)),
				() -> assertEquals(-1,mathUtils.Multiply(1, -1))
				);
		
	}
	
	@Test
	@Disabled
	@DisplayName("For TDD-Testing Disabled annotation")
	void testDisabled() {
		fail("The method should fail");
	}

}
