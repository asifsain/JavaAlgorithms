package com.asif.combinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PossibleMorningSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] progHrs = {65,40,30,45,45,5,60,45,30,30,45,60,60,45,30,30,60,30,30};
		
		double sum = 0d;
		
		int combinationIndex = 0;
		
//		for (int i = 0; i < progHrs.length; i++) {
//			sum += progHrs[i];
//			System.out.println(progHrs[i]);
//			if(sum >= 180)
//			{
//				System.out.println("----------SUM IS " + sum + "-------------------");
//				sum = 0;
//			}
//		}
		
		List<List<Integer>> listOfGoodSet = new ArrayList<List<Integer>>();
		
		PossibleMorningSession test = new PossibleMorningSession();
		for (int i = 0; i < progHrs.length; i++) {
			test.computeCombinations(0, progHrs, i, listOfGoodSet);
		}
		
		
		
		
		System.out.println("---------- ITEMS FINISHED-------------------");
		
		System.out.println(sum);
		System.out.println(sum/60);
		System.out.println((sum/60)/7);
		
		
		
		
		
		
		
	}

	private void computeCombinations(int startIndex, int[] progHrs, int commonIndex, List<List<Integer>> listOfGoodSet ) {
		// TODO Auto-generated method stub

		if(startIndex >= progHrs.length)
			return ;

		if(startIndex == commonIndex)
			startIndex++;
		
		List<String> hrsSet = new ArrayList<String>();
		List<Integer> goodSet = new ArrayList<Integer>();
		int sum = 0;
		boolean breakLoop = false;
		
		sum += progHrs[commonIndex];
		System.out.println("Index - "+ commonIndex + ", Value - " +progHrs[commonIndex]);
		goodSet.add(progHrs[commonIndex]);
		// hrsSet.add("Index - "+ commonIndex + ", Value - " +progHrs[commonIndex]);
		
		for (int i = startIndex; i < progHrs.length; i++) {
			
			if(i == commonIndex)
				continue;
			
			sum += progHrs[i];
			
			if(sum == 180)
			{
				// successful set
				System.out.println("Index - "+ i + ", Value - " +progHrs[i]);
				goodSet.add(progHrs[i]);
				// hrsSet.add("Index - "+ i + ", Value - " +progHrs[i]);
				breakLoop = true;
			}
			
			if(sum > 180)
			{
				// not successful set
				sum -= progHrs[i];
				breakLoop = true;
			}
			
			
			
			if(breakLoop)
			{
				if(sum == 180)
				{
//					for (Iterator iterator = hrsSet.iterator(); iterator.hasNext();) {
//						String string = (String) iterator.next();
//						System.out.println(string);
//					}
//					System.out.println("----------SUM IS "+ sum +"-------------------");
					listOfGoodSet.add(goodSet);
				}
				System.out.println("----------SUM IS "+ sum +"-------------------");
				break;
			}else {
				System.out.println("Index - "+ i + ", Value - " +progHrs[i]);
				goodSet.add(progHrs[i]);
				// hrsSet.add("Index - "+ i + ", Value - " +progHrs[i]);
			}
			
			
		}
		
		if(!breakLoop)
			return ;
		
		
		computeCombinations(++startIndex, progHrs, commonIndex, listOfGoodSet);
		
	}

}
