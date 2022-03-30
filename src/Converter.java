public class Converter {

    static double convertKM(int sumSteps) {
        return 0.00075*sumSteps;
    }
    static double convertCL(int sumSteps){
        return sumSteps/50;
    }

}
