import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int add(int opG, int opD) {
        return opG + opD;
    }
    public int sub(int opG, int opD) {
        return opG - opD;
    }
    public int mul(int opG, int opD) {
        return opG * opD;
    }
    public int divide(int opG, int opD) {
        if (opD == 0) {
            throw new ArithmeticException("error: division par zéro");
        }
        return opG / opD;
    }


    public Set<Integer> ensembleChiffres(int pNombres) {
        Set<Integer> result = new HashSet<Integer>();
        String str = String.valueOf(pNombres);

        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(str.charAt(i))) {
                result.add(Character.getNumericValue(str.charAt(i)));
            }
        }
        return result;
    }
}
