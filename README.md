This project illustrates a bug with method CtAnnotation#getValueOfObject:

https://github.com/INRIA/spoon/blob/0f8d748df3186304f76eb77aaf3ac7c3238127bf/src/main/java/spoon/support/reflect/declaration/CtAnnotationImpl.java#L328

This project declares an annotation processor (MyProcessor) that processes:

	public class C {
		@MyAnnot(name="a"+Integer.BYTES)
		void m() {}
	}

The project can be launched with:

	mvn clean compile exec:java

The execution fails with a java.lang.StackOverflowError due to an infinite recursion:

	at spoon.support.reflect.declaration.CtAnnotationImpl.convertElementToRuntimeObject(CtAnnotationImpl.java:267)
  
The annotation processor (MyProcessor) executes the following piece of code:

	public void process(CtAnnotation<?> element) {
		System.err.println(element);
		Object o = element.getValueAsObject("name");
		System.out.println(o);
	}

Note that the bug does not occur if Integer.BYTES in the annotation @MyAnnot(name="a"+Integer.BYTES) is replaced by another constant that belongs to the model built by Spoon.
