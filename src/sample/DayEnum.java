package sample;

/**
 * Created by chen on 2017/5/26.
 */
public enum DayEnum {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int code;

    DayEnum(int i) {
        this.code = i;
    }
}
