public class Converter {
    static final double STEP =0.00075;
    static final int CALORIE_STEP=50;


    public static double convertKM(int sumSteps) {
        return STEP*sumSteps;
    }
    public static double convertCL(int sumSteps){
        return sumSteps/CALORIE_STEP;
    }

}
