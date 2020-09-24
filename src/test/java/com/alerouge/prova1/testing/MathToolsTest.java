package com.alerouge.prova1.testing;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.params.provider.ValueSource;

class MathToolsTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("before all");
	}
	
	@AfterAll
	static void afterAll(){
		System.out.println("after all");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("before Each");
	}

	@AfterEach
	void afterEach(){
		System.out.println("after Each");
	}

	
	@Test
    void testConvertToDecimalSuccess() {
        double result = MathTools.convertToDecimal(3, 4);
        assertEquals(0.75, result);
    }

    @Test
    void testConvertToDecimalInvalidDenominator() {
        assertThrows(IllegalArgumentException.class, () -> MathTools.convertToDecimal(3, 0));
    }
 
//    @ParameterizedTest
//    @ValueSource(ints = {0, 2, 4, 6, 8, 10})
//    void testEvenSuccess(int number) {
//        assertTrue(MathTools.isEven(number));
//    }
    

//    @ParameterizedTest
//    @MethodSource("generateEvenNumbers")
//    void testEvenSuccess(int number) {
//        assertTrue(MathTools.isEven(number));
//    }
//
//    static IntStream generateEvenNumbers() {
//    	return IntStream.iterate(0, i -> i + 2).limit(100);
//    }

    
}
