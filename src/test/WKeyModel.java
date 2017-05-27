package test;

/**
 * Created by chen on 2017/5/24.
 */
public class WKeyModel {

    private Long id;
    private Integer type;
    private Integer index;// 自身索引
    private Integer mIndex;// 对应实际主密钥索引

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getMIndex() {
        return mIndex;
    }

    public void setMIndex(Integer mIndex) {
        this.mIndex = mIndex;
    }

    @Override
    public String toString() {
        return "WKeyModel{" +
                "id=" + id +
                ", type=" + type +
                ", index=" + index +
                ", mIndex=" + mIndex +
                '}';
    }
}
