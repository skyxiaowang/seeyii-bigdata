package com.seeyii.bigdata.spark.job;

import com.seeyii.bigdata.comm.spark.SparkJob;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.beans.Transient;
import java.util.Arrays;

/**
 * 描述：公司高管表清洗
 * 规则：001-001-001、001-001-002
 * @author wyf
 * @version V1.0
 * @created 2020/4/8 21:01
 */
//@Component
public class CompanyStaffClear extends SparkJob {
    @Override
    public void execute(JavaSparkContext javaSparkContext) {
        JavaRDD<Integer> parallelize = javaSparkContext.parallelize(Arrays.asList(1, 2, 3, 4), 3);
        Tuple2<Integer, Integer> reduce = parallelize.mapToPair(x -> new Tuple2<>(x, 1))
                .reduce((x, y) -> getReduce(x, y));
        System.out.println("数组sum:" + reduce._1 + " 计算次数:" + (reduce._2 - 1));
    }

    @Transient
    public Tuple2 getReduce(Tuple2<Integer, Integer> x, Tuple2<Integer, Integer> y) {
        Integer a = x._1();
        Integer b = x._2();
        a += y._1();
        b += y._2();
        return new Tuple2(a, b);
    }
}
