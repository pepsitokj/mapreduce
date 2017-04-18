package com.huizhuang.coming;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import com.huizhuang.mapreduce.map;
import com.huizhuang.reduce.reduce;


public class mapreduce {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf,"wordcount");
            
            //设置运行job的主类
            job.setJarByClass(mapreduce.class);
            //设置运行job的mapper类                            
            job.setMapperClass(map.class);
            //设置运行job的reduce类
            job.setReducerClass(reduce.class);
            job.setMapOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            job.setOutputValueClass(Text.class);
            job.setOutputKeyClass(Text.class);
            
            FileInputFormat.setInputPaths(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            boolean b=job.waitForCompletion(true);
            
            if(!b){
            	System.out.println("this task failed");
            }
	}

}
