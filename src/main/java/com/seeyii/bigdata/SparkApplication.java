package com.seeyii.bigdata;

import com.seeyii.bigdata.comm.spark.SparkJob;
import com.seeyii.bigdata.comm.utils.SpringBootBeanUtils;
import com.seeyii.bigdata.core.SparkConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.Utils;

/**
 * <b><code>SparkApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/4/12 9:55.
 *
 * @author Hu-Weihui
 * @since hui-bigdata-springboot ${PROJECT_VERSION}
 */
public class SparkApplication {

    public static void main(String[] args) {
        SparkApplication.run(args);
    }

    public static void run(String... args) {
               // 初始化Spark环境
        // 初始化Spark环境
        SparkConf sparkConf = new SparkConf()
                .setAppName("xxx")
                .setMaster("local[4]");

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        String className = args[0];
        try {
            //反射获取要执行的类
            Class clazz = Class.forName(className);
            //父类
            Class superclass = clazz.getSuperclass();
            //当前类的父类是SparkJob
            if(superclass.getTypeName().equals( SparkJob.class.getTypeName()) ){
                ((SparkJob) clazz.newInstance()).execute(javaSparkContext);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
