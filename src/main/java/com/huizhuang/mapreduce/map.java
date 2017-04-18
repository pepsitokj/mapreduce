package com.huizhuang.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;



public class map extends Mapper<LongWritable, Text, Text, Text> {
	
//	private static Logger logger=(Logger) LoggerFactory.getLogger(map.class);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String line = value.toString();
		String[] words = line.split(":");
//			logger.info(words);
			System.out.println(words);
		String[] wordb =words[1].split(",");
//		    logger.info(wordb);
			System.out.println(wordb);
		for (String word : wordb) {
//			logger.info("word:"+word);
			System.out.println(word);
			context.write(new Text(word),new Text(words[0]));
		}
//		super.map(key, value, context);
	}

	

}
