package zPattern.Singleton;

//Why Singleton is Anti pattern 
//
//With more and more classes calling getInstance() the code gets more and more 
//tightly coupled, monolithic, not testable and hard to change and hard to reuse 
//because of not configurable, hidden dependencies. Also, there would be no need 
//for this clumsy double checked locking if you call getInstance less 
//often (i.e. once).
	
//Singleton using Enum in Java
//This is the way we generally declare Enum Singleton , it may contain 
//instace variable and instance method but for sake of simplicity I haven't 
//used any, just beware that if you are using any instance method than you need 
//to ensure thread-safety of that method if at all it affect the state of 
//object. By default creation of Enum instance is thread safe but any other
//method on Enum is programmers responsibility.

public enum EasySingleton{
    INSTANCE;
}

// You can access it by EasySingleton.INSTANCE, much easier than calling
// getInstance() method on Singleton.

