package com.gdw888.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	ArrayList<Vertex> vertices;
	
	public class Vertex{
		String node;
		ArrayList<String> edges;
		
		public Vertex(String name) {
			this.node = name;
			this.edges = new ArrayList<String>();
		};
		
		public boolean nodeNameMatchWith(String name) {
			return (node.equals(name));
		}
		
		public void addEdge(String node) {
			this.edges.add(node);
		}
		
		public void removeEdge(String node) {
			this.edges.remove(node);
		}
	}
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(String node) {
		vertices.add(new Vertex(node));
	}
	
	public void removeVertex(String node) {
		for (Vertex vertex : vertices) {
			if (vertex.nodeNameMatchWith(node)) {
				vertices.remove(vertex);
				break;
			}
		}

		for (Vertex vertex : vertices) {
			vertex.removeEdge(node);
		}
	}
	
	public void addEdge(String node1, String node2) {
		for (Vertex vertex : vertices) {
			if(vertex.nodeNameMatchWith(node1)) {
				vertex.addEdge(node2);
			}
			if(vertex.nodeNameMatchWith(node2)) {
				vertex.addEdge(node1);
			}
		}
	}
	
	public void printGraphHelper(Queue<String> queue, ArrayList<String> printedNodes) {
		if (!queue.isEmpty()) {
			String tempNode = queue.poll();
			
			if (!printedNodes.contains(tempNode)) {
				System.out.println(tempNode);
				printedNodes.add(tempNode);
				
				for (Vertex vertex : vertices) {
					if(vertex.nodeNameMatchWith(tempNode)) {
						for (String edge : vertex.edges) {
							if (!queue.contains(edge)) {
								queue.add(edge);
							}
						}
						break;
					}
				}
			}
			printGraphHelper(queue, printedNodes);
		}
	}
	
	public void printGraph(){
		Queue<String> queue = new LinkedList<>();
		queue.add(vertices.get(0).node);
		printGraphHelper(queue, new ArrayList<String>());
	}
	
	public static void main(String args[]) {
	    Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addVertex("Terry");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Terry");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    
	    graph.printGraph();
	}

}
