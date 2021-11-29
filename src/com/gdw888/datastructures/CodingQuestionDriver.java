package com.gdw888.datastructures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CodingQuestionDriver {
	
	@Value("${question}")
	private String questionName;

	@Autowired
	BinaryTreeExample binaryTreeExampleOne;
	
	@Autowired
	BinaryTreeExample binaryTreeExampleTwo;
	
	@Autowired
	IntegerArrayExample integerArrayExampleOne;
	
	@Autowired
	IntegerArrayExample integerArrayExampleTwo;
	
	public String getQuestionName() {
		return this.questionName;
	}
	
	public void validateAnswer(CodingSolution codingSolution) {
		
		int numTestCase = 0;
		String solution = "";
		QuestionExample[] examples = null;
		
		System.out.println("==="+codingSolution.getQuestionName().toUpperCase() + " QUESTIONS===");

		if (codingSolution.isBinaryTree()) {
			numTestCase = 2;
			examples = new QuestionExample[2];
			examples[0] = binaryTreeExampleOne;
			examples[1] = binaryTreeExampleTwo;
		}else if (codingSolution.isIntegerArray()) {
			numTestCase = 2;
			examples = new QuestionExample[2];
			examples[0] = integerArrayExampleOne;
			examples[1] = integerArrayExampleTwo;
		}
		
		for (int i=0; i<numTestCase; i++) {
			System.out.println("TESTCASE #"+i);
			codingSolution.setExample(examples[i].getExample());
			System.out.println("BEFORE:\n" + examples[i].exampleToString());
			System.out.println("Solution: "+codingSolution.solution(codingSolution.getSolutionReturnType()));
			System.out.println("AFTER\n" + examples[i].exampleToString());
			
		}
	}
}
