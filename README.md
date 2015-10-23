# spark
learning spark

This program just counts the number of lines containing ‘a’ and the number containing ‘b’ in a text file. Note that you’ll need to replace YOUR_SPARK_HOME with the location where Spark is installed. As with the Scala example, we initialize a SparkContext, though we use the special JavaSparkContext class to get a Java-friendly one. We also create RDDs (represented by JavaRDD) and run transformations on them. Finally, we pass functions to Spark by creating classes that extend spark.api.java.function.Function. The Spark programming guide describes these differences in more detail.
