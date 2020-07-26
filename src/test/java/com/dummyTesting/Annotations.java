package com.dummyTesting;


import java.lang.annotation.*;
import java.lang.reflect.Method;


public class Annotations {
    @Documented
    @Target(ElementType.METHOD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MethodInfo{
        String author() default "amritha";
        String date();
        int revision() default 1;
        String comments();

    }
    @Override
    @MethodInfo(author="amritha",comments="Main method",date="27 Nov 2012",revision=1)
    public String toString(){
        return "Overridden to String method";
    }

    @Deprecated
    @MethodInfo(comments="Deprecated comments",date="27 Nov 2012")
    public static void oldMethod(){
        System.out.println("OldMethod dont use it");
    }

    public static  void main(String args[]){
        try{
            for(Method method:Annotations.class.getMethods()){
                //checks if methodinfo annotation is present for the method
                if(method.isAnnotationPresent(MethodInfo.class)){
                    try{
                        //iterates all annotations available in method
                        for(Annotation ano:method.getDeclaredAnnotations()){
                            System.out.println("Annotation in  Method" +method+ ": "+ano);
                        }
                        MethodInfo methodAnno=method.getAnnotation(MethodInfo.class);
                        if(methodAnno.revision()==1){
                            System.out.println("Method with revision no 1 :" +method);
                        }
                    }catch (Throwable e){
                        e.printStackTrace();

                    }
                }
            }

        }catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}

