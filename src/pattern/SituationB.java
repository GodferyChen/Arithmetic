package pattern;

/**
 * B战区-具体同事类
 * Created by chen on 2018/3/23.
 */
public class SituationB extends Colleague{

    public SituationB(Mediator mediator) {
        super(mediator);
    }

    // 请求支援
    public void bRequestSupport() {
        super.mediator.execute("bRequestSupport");
    }

    public void bSupport(boolean isSupport) {
        if (isSupport) {
            System.out.println("SituationB：Copy that，还有五秒钟到达战场");
        } else {
            System.out.println("-------B也正在被攻打--------");
            System.out.println("SituationB：支援你妹，我也正在被攻打");
        }
    }

}
