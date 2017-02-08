package com.ksyang.amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeightedRandomSelected {
	
	public static void main(String[] args){
		
		WeightedRandomSelected selector = new WeightedRandomSelected();
		
		LinkedList list = selector.new LinkedList(1.6, null);
		list.add(selector.new LinkedList(0.2, null));
		list.add(selector.new LinkedList(0.6, null));
		list.add(selector.new LinkedList(5.5, null));
		list.add(selector.new LinkedList(7.0, null));
		list.add(selector.new LinkedList(4.1, null));
		list.add(selector.new LinkedList(2.5, null));
		list.add(selector.new LinkedList(9.2, null));
		
		Map<LinkedList, double[]> weightedMap = new HashMap<>();
		
		double totalWeight = 0.0;
		LinkedList node = list;
		
		while(node!=null){
			double[] range = new double[2];
			range[0] = totalWeight;
			range[1] = totalWeight+node.getValue();
			weightedMap.put(node, range);
			totalWeight = totalWeight+node.getValue();
			node = node.next;
		}
		
		int tries =0;
		while(tries<10){
			double r = Math.random()*totalWeight;
			LinkedList foundNode = null;
			
			Set<LinkedList> keySet = weightedMap.keySet();
			Iterator<LinkedList> itr = keySet.iterator();
			while(itr.hasNext()){
				LinkedList n = itr.next();
				if(r>weightedMap.get(n)[0] && r<=weightedMap.get(n)[1]){
					foundNode = n;
					break;
				}
			}
			System.out.println(foundNode.getValue());
			tries++;
		}
		
		
		
		
	}
	

	private class LinkedList{
		private double value;
		private LinkedList next;
		
		public LinkedList(double value, LinkedList next) {
			this.value = value;
			this.next = next;
		}
		
		public void add(LinkedList next){
			
			if(this.getNext() == null){
				this.setNext(next);
				return;
			}
			
			this.getNext().add(next);
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public LinkedList getNext() {
			return next;
		}

		public void setNext(LinkedList next) {
			this.next = next;
		}
		
	}
}
