package com.gdw888.datastructures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IntegerArrayExampleOne extends IntegerArrayExample {
	public IntegerArrayExampleOne(@Value("${integerArrayListExampleOne}") String arrayList) {
		super(arrayList);
	}
}
