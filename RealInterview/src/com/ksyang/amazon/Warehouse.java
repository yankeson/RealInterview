package com.ksyang.amazon;

/*
 * Algorithm/Data structure to meet Customers requirement based on 
 * their Shipping preference and shipping costs as well 

I have this requirement i.e., given products and their customer locations 
I have to map products to Warehouse based on customer location & choice. 

For example: 
P1, P2, P3 are my products 
D1, D2, D3 are the destination with respect to products. 
W1, W2, W3 are my warehouses. 
W1 operates to Destinations D1, D2 and D3. 
W2 operates to Destinations D1, D3. 
W3 operates to Destinations D1, D2. 
P1 is available in W1 & W2. 
P2 is available in W2 & W3. 
P3 is available in W1 & W3. 

Every warehouse operates on different modes of transportation
(By Air, By Ground.. etc) [# of Days to reach & $ amount of cost] for each mode. 

Now the question is to minimize my orders based on Customer Choice 
provided in the order class. 

My Order class looks something like this 

Class Order{ 
	Destination D1; 
	Product P1; 
	Quantity Q1; 
	CustomerChoice Ch;//Standard, 1-day, 2 day. 
}

void processOrder(List<Order> lstOrder){ 
	//Process all order to get list of products and their destinations. 
	List<String> lstProductIds; 
	List<String> lstDestination;//Destinations are w.r.t to Products. 
	//What Datastructe should I get from this method ?? 
	getWarehouseMapping(lstProductIds, lstDestination); 
	//Process all the orders and complete them as much as possible. 
} 
public <??????> getWarehouseMapping(List<String> lstProductIds, List<String> lstDestination){ 
	//1. I am supposed to implement this. 
	//2. Loop through products get their corresponding warehouses. 
	//3. Based on their destinations I should get the shipping Modes and their prices as well(Air, Ground etc). 
}

Can someone please suggest me an efficient algorithm or a data structure where 
I can store all my mapping details so that I can operate through the Orders 
effectively?
 */
public class Warehouse {

}
