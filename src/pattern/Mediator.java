package pattern;

/**
 * 抽象中介者
 * Created by chen on 2018/3/23.
 */
public abstract class Mediator {

    protected SituationA situationA;
    protected SituationB situationB;
    protected SituationC situationC;

    public Mediator(){
        situationA = new SituationA(this);
        situationB = new SituationB(this);
        situationC = new SituationC(this);
    }

    /**
     * 事件的业务流程处理
     *
     * @param method
     */
    public abstract void execute(String method);

}
