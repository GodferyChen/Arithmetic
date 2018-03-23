package pattern;

/**
 * C战区-具体同事类
 * Created by chen on 2018/3/23.
 */
public class SituationC extends Colleague{

    public SituationC(Mediator mediator) {
        super(mediator);
    }

    // 请求支援
    public void cRequestSupport() {
        super.mediator.execute("cRequestSupport");
    }

    public void cSupport(boolean isSupport) {
        if (isSupport) {
            System.out.println(getClass().getSimpleName() + "：Copy that，还有五秒钟到达战场");
        } else {
            System.out.println(getClass().getSimpleName() + "：不好意思，来迟一步了，正在前往别的战区支援");
        }
    }


}
