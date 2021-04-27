package lab3.Methods;

import lab3.Exсeptions.FirstBreakPoint;
import lab3.Exсeptions.SecondBreakPoint;

import java.util.function.Function;

public class SimpsonMethod implements BasicMethod {
    @Override
    public double getIntegral(int n, double a, double b, Function<Double, Double> function) {
        double h = (b - a) / n;
        double[] y = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            try {
                y[i] = function.apply(a + i * h);
            } catch (FirstBreakPoint e) {
                y[i] = 0;
            } catch (SecondBreakPoint e) {
                if (-b == a) y[i] = 0;
                else
                    throw new RuntimeException("Разрыв второго рода для симметричной функции на несимметричном интервале");
            }
        }
        double I0 = h / 3 * (y[0] + y[n]);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) I0 += 4 * h / 3 * y[i];
            else I0 += 2 * h / 3 * y[i];
        }
        return I0;
    }
}
