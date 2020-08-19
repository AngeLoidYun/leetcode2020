package me.angeloid.ttt;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020/7/10
 */
public class Test {
    public static void main(String[] args) {
        String s ="\"5972076\",\"HQGF01500052BGN00\",\"中国电信IMS网络建设（2015年）核心网（扩容）工程设备及相关服务采购合同（华为/股份）\",\"285000.01\",\"58573208\",\"\",\"中国电信股份有限公司\",\"2015-11-25 00:00:00\",\"2016-11-25 00:00:00\",\"1\",\"2015-11-25 00:00:00\",\"9\",\"2016-08-15 12:12:43\"";
        String[] inner = s.replace("\"", "").split(",");
        System.out.println(Arrays.toString(inner));
        long v = Long.parseLong(inner[0]);
        System.out.println(v);
    }
}
