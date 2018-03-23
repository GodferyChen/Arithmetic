package pattern;

/**
 * Created by chen on 2018/3/23.
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new Command();
        System.out.println("-------A被攻打，请求支援--------");
        SituationA situationA = new SituationA(mediator);
        situationA.aRequestSupport();
    }

}
