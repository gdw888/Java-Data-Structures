package com.gdw888.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class mutexExample implements Runnable  {
	
	private Thread t;
	
	final int numList    = 100;
	final int numThreads = 5;
	
	Thread	  threadArray[];
	@SuppressWarnings("rawtypes")
	ArrayList arrayList[];
	
	boolean   printedIndex[];
	
	private ReentrantLock mutex;
	
	@SuppressWarnings("unchecked")
	public mutexExample(){
		int element = 0;
		
		mutex = new ReentrantLock();
		
		arrayList = new ArrayList[numList];
		
		for (int i = 0; i < arrayList.length; i++)
		{
			arrayList[i] = new ArrayList<String>();
			
			for ( int j = 0; j < numList; j++)
			{
				arrayList[i].add(Integer.toString(element++));
			}
		}
	}
	
	public void printArray(int index){
	
		System.out.println("print array #" + index);
				
		List<String> list =  arrayList[index];
		
		for (String element : list){
			//System.out.println(element);
		}

	}
	
	public void printArrayUsingThreads()
	{
		int threadCount = 0;

		printedIndex = new boolean[numList];
		threadArray  = new Thread[numThreads];
		
		do
		{
			threadArray[threadCount] = new Thread(this,"Thread"+threadCount);
			threadArray[threadCount].start();
			threadCount++;
		
		}while(numThreads > threadCount);
		
		threadCount = 0;
		
		while (numThreads > threadCount)
		{
			try {
				threadArray[threadCount].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadCount++;
		}
	}
	
	public static void main(String[] args){
		mutexExample learn = new mutexExample();
		learn.printArrayUsingThreads();
		
		System.out.println("Finished printing the arraylist");
	}
	
	public int getNextArrayList(){
		int arrayIndex = -1;
		try {
            mutex.lock();
            
            for (int curIndex = 0; curIndex < printedIndex.length; curIndex++)
            {
            	if ( printedIndex[curIndex] == false )
            	{
            		printedIndex[curIndex] = true;
            		arrayIndex = curIndex;
            		break;
            	}
            }
        } finally {
            mutex.unlock();
        }
		
		return arrayIndex;
	}

	@Override
	public void run() {
		int getNextIndex = getNextArrayList();
		
		while (getNextIndex != -1)
		{
			Thread thisThread = Thread.currentThread();
			System.out.println(thisThread.getName());
			printArray(getNextIndex);
			getNextIndex = getNextArrayList();
		}
	}
	
	public class threadClass extends Thread
	{
		
	}
}
