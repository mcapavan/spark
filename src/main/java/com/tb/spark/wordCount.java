package com.tb.spark;

import java.util.Arrays;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class wordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String logFile = "README.md"; // Should be some file on your system
		// Create a Java Spark Context
		SparkConf conf = new SparkConf().setAppName("wordCount");
		JavaSparkContext sc = new JavaSparkContext(conf);
		// Load our input data.
		JavaRDD<String> input = sc.textFile(logFile);
		// Split up into words.
		JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
			public Iterable<String> call(String x) {
				return Arrays.asList(x.split(" "));
			}
		});
		// Transform into pairs and count.
		JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {

			public Tuple2<String, Integer> call(String x) {
				return new Tuple2(x, 1);
			}
		}).reduceByKey(new Function2<Integer, Integer, Integer>() {
			public Integer call(Integer x, Integer y) {
				return x + y;
			}
		});
		// Save the word count back out to a text file, causing evaluation.
		counts.saveAsTextFile("outputFile");
	}

}
