package com.example.myapplication8.bean;

import com.example.myapplication8.R;

import java.util.ArrayList;

public class Planet {

    public int image;
    public String name;
    public String desc;

    public Planet(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static int[] iconArray = {R.drawable.meizu, R.drawable.lenovo, R.drawable.xiaomi,
            R.drawable.hongmo, R.drawable.apple, R.drawable.huawei,
            R.drawable.huaweip, R.drawable.rongyu, R.drawable.oppo,
            R.drawable.vivo};
    private static String[] nameArray = {"魅族17", "联想拯救者", "小米10至尊纪念版", "红魔5S", "iPhone 12 Pro Max", "HUAWEI Mate 40 Pro",
            "HUAWEI P40 Pro+","柔宇ROYOLE FlexPai 2","OPPO Reno3 Pro","vivo X50 Pro+"};
    private static String[] descArray = {
            "魅族17 8GB+128GB 十七度灰 骁龙865 旗舰5G手机 30W快充 6400W后置主摄 90Hz屏幕 支持NFC 智能拍照游戏手机",
            "联想拯救者电竞手机Pro 12GB+128GB 骁龙865 Plus 双液冷散热 144Hz电竞屏 双模5G游戏手机 炽焰战甲",
            "小米10 至尊纪念版 双模5G 骁龙865 120HZ高刷新率 120倍长焦镜头 120W快充 8GB+128GB 陶瓷黑 游戏手机",
            "努比亚 nubia 红魔5S 8GB+128GB 冰封银翼 电竞游戏手机 144Hz屏幕刷新率 内置风扇散热",
            "Apple iPhone 12 Pro Max (A2412) 512GB 石墨色 支持移动联通电信5G 双卡双待手机",
            "华为 HUAWEI Mate 40 Pro麒麟9000 SoC芯片 超感知徕卡电影影像 有线无线双超级快充8GB+256GB夏日胡杨（必购）",
            "华为 HUAWEI P40 Pro+ 麒麟990 5G SoC芯片 5000万超感知徕卡五摄 100倍双目变焦 8GB+512GB陶瓷黑全网通5G",
            "柔宇ROYOLE FlexPai 2 新一代5G双模折叠屏手机 骁龙865旗舰四摄 类镜面平整度 柔派2 星空灰8GB+256GB",
            "OPPO Reno3 Pro 双模5G 视频双防抖 90HZ高感曲面屏 7.7mm轻薄机身 8GB+128GB 日出印象 拍照游戏视频手机",
            "vivo X50 Pro+ 5G手机 8+256GB 引力 超清一亿模式 高通骁龙865 60倍超级变焦 双模5G全网通手机"
    };

    public static ArrayList<Planet> getDefaultList() {
        ArrayList<Planet> planetList = new ArrayList<Planet>();
        for (int i = 0; i < iconArray.length; i++) {
            planetList.add(new com.example.myapplication8.bean.Planet(iconArray[i], nameArray[i], descArray[i]));
        }
        return planetList;
    }
}
