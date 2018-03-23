package pattern;

/**
 * A战区-具体同事类
 * Created by chen on 2018/3/23.
 */
public class SituationA extends Colleague{

    public SituationA(Mediator mediator) {
        super(mediator);
    }

    // 请求支援
    public void aRequestSupport() {
        super.mediator.execute("aRequestSupport");
    }

    public void aSupport(boolean isSupport) {
        if (isSupport) {
            System.out.println(getClass().getSimpleName() + "：Copy that，还有五秒钟到达战场");
        } else {
            System.out.println(getClass().getSimpleName() + "：不好意思，正在前往别的战区支援");
        }
    }

}
