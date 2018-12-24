package com.chx.tools.UDF;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * @Author yanuun
 * @Date 13:37 2018/12/24
 **/
public class UdfDemo extends UDF {

    public Text evaluate(Text input){
        return new Text("Hello:" + input);
    }

    public static void main(String[] args){
        UdfDemo udf = new UdfDemo();
        Text result = udf.evaluate(new Text("caozun"));

        System.out.println(result.toString());
    }
}
