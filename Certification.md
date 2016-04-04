# HDP Spark Certification preparation

The HDP Certified Spark Developer (HDPCD:Spark) exam has two main categories of tasks that involve:

- Spark Core
- Spark SQL

The exam is based on the Hortonworks Data Platform 2.4 installed and managed with Ambari 2.2, which includes Spark 1.6.0 and Hive 1.2.1. Each candidate will be given access to an HDP 2.4 cluster along with a list of tasks to be performed on that cluster.

Reference: [Spark programming-guide](http://spark.apache.org/docs/latest/programming-guide.html)

### Write a Spark Core application in Python or Scala

- resilient distributed dataset (RDD)
- Sometimes, a variable needs to be shared across tasks, or between tasks and the driver program. Spark supports two types of shared variables: **broadcast variables**, which can be used to cache a value in memory on all nodes, and **accumulators**, which are variables that are only “added” to, such as counters and sums.

**Initializing Spark** The first thing a Spark program must do is to create a SparkContext object, which tells Spark how to access a cluster. To create a SparkContext you first need to build a SparkConf object that contains information about your application.

Only one SparkContext may be active per JVM. You must stop() the active SparkContext before creating a new one.

```
val conf = new SparkConf().setAppName(appName).setMaster(master)
new SparkContext(conf)
```
The appName parameter is a name for your application to show on the cluster UI. master is a Spark, Mesos or YARN cluster URL, or a special “local” string to run in local mode. In practice, when running on a cluster, you will not want to hardcode master in the program, but rather launch the application with spark-submit and receive it there. However, for local testing and unit tests, you can pass “local” to run Spark in-process.

For example, to run bin/spark-shell on exactly four cores, use:

``` $ ./bin/spark-shell --master local[4] ```

Or, to also add code.jar to its classpath, use:

``` $ ./bin/spark-shell --master local[4] --jars code.jar ```

To include a dependency using maven coordinates:

``` $ ./bin/spark-shell --master local[4] --packages "org.example:example:0.1"  ```

For a complete list of options, run **spark-shell --help**. Behind the scenes, spark-shell invokes the more general spark-submit script.
