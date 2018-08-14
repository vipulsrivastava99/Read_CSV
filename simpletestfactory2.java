package com.qait.advancetatoc;

import org.testng.annotations.Factory;

class simpletestfactory2
{
   @Factory
   public Object[] factoryMethod() {
       return new Object[] {
                               new SimpleTest2("one"),
                               new SimpleTest2("two")
                           };
   }
}