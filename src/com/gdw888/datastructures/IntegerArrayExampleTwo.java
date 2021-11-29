package com.gdw888.datastructures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IntegerArrayExampleTwo extends IntegerArrayExample {
	public IntegerArrayExampleTwo(@Value("${integerArrayListExampleTwo}") String arrayList) {
		super(arrayList);
	}
}
