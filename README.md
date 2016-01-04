# spark
learning spark

This program just counts the number of lines containing ‘a’ and the number containing ‘b’ in a text file. Note that you’ll need to replace YOUR_SPARK_HOME with the location where Spark is installed. As with the Scala example, we initialize a SparkContext, though we use the special JavaSparkContext class to get a Java-friendly one. We also create RDDs (represented by JavaRDD) and run transformations on them. Finally, we pass functions to Spark by creating classes that extend spark.api.java.function.Function. The Spark programming guide describes these differences in more detail.
The output will be 4 lines for 'a' and 2 lines for 'b'

To submit spark job from HDP sandbox:

1. git clone https://github.com/mcapavan/spark.git
2. cd spark
3. hadoop fs -put README.md
4. /usr/hdp/current/spark-client/bin/spark-submit --class "com.tb.spark.SimpleApp" --master local[4] target/spark-0.0.1-SNAPSHOT.jar

Spark Interview Question are available at https://github.com/mcapavan/spark/blob/master/src/docs/InterviewQuestions.md

Hadoop Interview Questions are available at https://intellipaat.com/interview-questions/





