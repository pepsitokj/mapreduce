package com.huizhuang.reduce;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reduce extends Reducer<Text, Text, Text, Text>{

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		StringBuilder friends=new StringBuilder();
		
		for (Text value:values){
			friends.append(value.toString());
			
		}
		context.write(key, new Text(friends.toString()));
//		super.reduce(arg0, arg1, arg2);
	}

}
