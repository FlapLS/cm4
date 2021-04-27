package lab3.Function;

import lab3.Exсeptions.FirstBreakPoint;
import lab3.Exсeptions.SecondBreakPoint;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

import static java.lang.Math.*;

@Getter
public enum Functions {
    f1(x -> 3 * pow(-x, 3) - pow(x, 2) + x + 3, "-3x^3 - x^2 + x + 3 dx"),
    f2(x -> pow(x, 3) - x + 4, "x^3 - x + 4 dx"),
    f3(x->{
        if (x!=0) return 1/x;
        else throw new SecondBreakPoint("Разрыв втрого рода");
    },"1/x"),
    f4(x->{
        if (x!=0) return sin(x)/x;
        else throw new FirstBreakPoint("Разрыв первого рода");
    },"sin(x)/x"),
    f5(x->exp(x/2),"e^(x/2)");
    private String text;
    private double left;
    private double right;
    private Function<Double,Double>function;
    @Setter
    private double epsilon;
    Functions(Function<Double, Double> function, String text){
        this.function=function;
        this.text=text;
    }
    public void setLimits(double a,double b){
        this.left=a;
        this.right=b;
    }
}
