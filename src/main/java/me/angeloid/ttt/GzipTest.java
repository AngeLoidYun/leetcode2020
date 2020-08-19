package me.angeloid.ttt;


import java.io.IOException;

/**
 * @author AngeloidYun
 * @date 2020/7/8
 */
public class GzipTest {
    public static void main(String[] args) {
        String s = "[\n" +
                "    {\n" +
                "        \"FPHM\": \"我是测试发票号码1\",\n" +
                "        \"FPDM\": \"我是测试发票代码1\",\n" +
                "        \"pdfUrl\": \"我是测试电子发票版式文件在线查看URL1\",\n" +
                "\t\t\"antiFakeCode\": \"我是测试防伪码1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"FPHM\": \"我是测试发票号码2\",\n" +
                "        \"FPDM\": \"我是测试发票代码2\",\n" +
                "        \"pdfUrl\": \"我是测试电子发票版式文件在线查看URL2\",\n" +
                "\t\t\"antiFakeCode\": \"我是测试防伪码2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"FPHM\": \"我是测试发票号码3\",\n" +
                "        \"FPDM\": \"我是测试发票代码3\",\n" +
                "        \"pdfUrl\": \"我是测试电子发票版式文件在线查看URL3\",\n" +
                "\t\t\"antiFakeCode\": \"我是测试防伪码3\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"FPHM\": \"我是测试发票号码4\",\n" +
                "        \"FPDM\": \"我是测试发票代码4\",\n" +
                "        \"pdfUrl\": \"我是测试电子发票版式文件在线查看URL4\",\n" +
                "\t\t\"antiFakeCode\": \"我是测试防伪码4\"\n" +
                "    }\n" +
                "]";
        try {
            byte[] array = GZipUtil.compress(s);
            System.out.println(Base64Utils.encode(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s2 = "H4sIAAAAAAAAAIvmUgCCajAJAkpuAR6+SlYKSs86Jj6bsf7Z1u4X66c+7Z/4fOmKp/3bny9oNFTSQVbsgkPxk92L0RUXpKSFFuWgK38+ZevTtRMgmp53djzd0/9sWvuT3duezlnxfNf+Z/OXPp/THRrkAzKJk1MpMa8k0y0xO9U5PyUV3aSXMzY92bMKbCvY0lodUv1mRIrfjKjmNyMS/GZErt+MSfGbMdX8ZkyC34zJ9ZsJKX4zoZrfTEjwmwnUb1yxABxzdOxyAwAA";
        String res = new String(GZipUtil.uncompress(Base64Utils.decode(s2)));
        System.out.println(res);
    }
}
