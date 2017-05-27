package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/5/24.
 */
public class test {

    private static List<WKeyModel> wKeyModelList = new ArrayList<>();  // 工作秘钥

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            loadMainKey((int) (100+Math.random()*5));
        }
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random()*5+100);
            loadWorkKey(1,random,1000+i);
        }
        for (WKeyModel model : wKeyModelList) {
            System.out.println(model.toString());
        }
    }

    public static boolean loadMainKey(int mkIndex){
        //存储此主秘钥的映射
        WKeyModel wKeyModel_tmp = getMkeyModel(mkIndex);
        if(wKeyModel_tmp != null){ // 更新
//            wKeyModel_tmp.setType(4);
//            wKeyModel_tmp.setMIndex(wKeyModel_tmp.getMIndex());
//            wKeyModel_tmp.setIndex(mkIndex);
//            wKeyModelDao.update(wKeyModel_tmp);
        } else { // 添加
            wKeyModel_tmp = new WKeyModel();
            wKeyModel_tmp.setType(4);
            //遍历wKeyModelList返回所有type为4的主密钥索引的个数
            wKeyModel_tmp.setMIndex(getMkeySize());
            wKeyModel_tmp.setIndex(mkIndex);
//            wKeyModelDao.insert(wKeyModel_tmp);
            wKeyModelList.add(wKeyModel_tmp);
        }
        return true;
    }

    public static boolean loadWorkKey(int keyType, int mkIndex, int wkIndex){
        //先判断主密钥索引是否存在，不存在返回error
        WKeyModel mKeyModelTemp = getMkeyModel(mkIndex);
        if(mKeyModelTemp == null){
            System.out.println("mkIndex error->"+ mkIndex);
            return false;
        }

        // 存储此工作秘钥的映射
        WKeyModel wKeyModel_tmp = getWkeyModel(wkIndex);
        if(wKeyModel_tmp != null){ // 如果是已经存在的数据，则直接覆盖掉
            wKeyModel_tmp.setType(keyType);
            wKeyModel_tmp.setMIndex(mKeyModelTemp.getMIndex());//主密钥索引拿我们自己的
            wKeyModel_tmp.setIndex(wkIndex);
//            wKeyModelDao.update(wKeyModel_tmp);
        } else { // 不存在的话，则新添加
            wKeyModel_tmp = new WKeyModel();
            wKeyModel_tmp.setType(keyType);
            wKeyModel_tmp.setMIndex(mKeyModelTemp.getMIndex());
            wKeyModel_tmp.setIndex(wkIndex);
//            wKeyModelDao.insert(wKeyModel_tmp);
            wKeyModelList.add(wKeyModel_tmp);
        }
        return true;
    }

    // 通过wkindex寻找对应的映射
    public static WKeyModel getWkeyModel(int index){
        WKeyModel wkeymodel_tmp = null;
        for (WKeyModel wkeymodel : wKeyModelList) {
            if(wkeymodel.getIndex() == index && wkeymodel.getType() < 4){
                wkeymodel_tmp = wkeymodel;
            }
        }
        return wkeymodel_tmp;
    }

    // 通过mkIndex寻找对应的映射
    public static WKeyModel getMkeyModel(int index){
        WKeyModel mKeyModelTmp = null;
        for (WKeyModel wkeymodel : wKeyModelList) {
            if(wkeymodel.getIndex() == index && wkeymodel.getType() == 4){
                mKeyModelTmp = wkeymodel;
            }
        }
        return mKeyModelTmp;
    }

    /**
     * 返回主密钥索引个数
     * @return
     */
    public static int getMkeySize(){
        int res = 0;
        for (WKeyModel wkeymodel : wKeyModelList) {
            if(wkeymodel.getType() == 4){
                res++;
            }
        }
        return res;
    }
}
