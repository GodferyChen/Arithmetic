package pattern;

/**
 * 抽象同事类
 * Created by chen on 2018/3/23.
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
