package pkg;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;

public class MyProcessor extends AbstractProcessor<CtAnnotation<?>> {

	public void process(CtAnnotation<?> element) {
		System.err.println(element);
		Object o = element.getValueAsObject("name");
		System.out.println(o);
	}
}
