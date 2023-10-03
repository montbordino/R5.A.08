import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }


    @ParameterizedTest
    @CsvSource ({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void tester_additions(int opG, int opD, int resultIntended) {
        int result = calc.add(opG, opD);
        assertEquals(resultIntended, result);
    }

    @ParameterizedTest
    @CsvSource ({
            "2, 2, 1",
            "6, 2, 3",
            "-3, 3, -1",
            "1, 1, 1",
            "-1000, -10, 100",
            "0, 0, 0"
    })
    void tester_divisions(int opG, int opD, int resultIntended) {
        try {
            int result = calc.divide(opG, opD);
            assertEquals(resultIntended, result);

        }

        catch (ArithmeticException e1){
            System.out.println("error: division par zéro");
        }
    }

    @ParameterizedTest
    @CsvSource ({
            "123, 1",
            "123, 2",
            "123, 3"
    })

    void tester_ensembleChiffres_contenu(int startNumber, int contain) {
        Set<Integer> result = calc.ensembleChiffres(startNumber);
        assertTrue(result.contains(contain));
    }

    @ParameterizedTest
    @CsvSource ({
            "123, 3",
            "113, 2",
            "111, 1"
    })

    void tester_ensembleChiffres_taille(int startNumber, int supposedSize) {
        Set<Integer> result = calc.ensembleChiffres(startNumber);
        assertTrue(result.size() == supposedSize);
    }
}