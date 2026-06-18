class Solution {
    public double angleClock(int hour, int minutes) {
        double x=hour+minutes/60.0;
        double angle=(11*x)%12;
        return Math.min(angle, 12-angle)*30.0;
    }
}