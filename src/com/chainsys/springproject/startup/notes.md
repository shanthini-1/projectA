
  1. Constructor automatically invoked when application context is loaded
  1. First JVM loaded
  1. ApplicationContext is loaded
  1. ApplicationContext reads xml configuration file
  1. ApplicationContext pre-loads one object for each bean in the config file
      if not marked as        lazy-init="true"
  1. lazy-init="true" this inform spring container not to preload object for this bean
  1. For lazy-init means obect is created only when the getBean() method is called 
  1. For pre-init beans getBean() return the reference of the preloaded object.
  1. By default only one object for every bean is created(singleton)
  1. Singleton: Atleast one object for every class but not more than one object
  1. Spring for lazy-init beans creates a singleton object on firstcall of getBeans methods()
  1. And then uses that object for futures getBean() method calls.
  
  
---  
  
## Prototype

- Prototype beans are by default lazy-init  
- Prototypes are not singleton  
- A new object is created for prototype when getBean() method is called everytime

 ``` xml
      <bean  id="actor" class = "com.chainsys.projectA.beans.Actor"scope="prototype"></bean>	
 ```
----

##Bean with parameterize constructor

 ```
    <bean  id="film" class = "com.chainsys.projectA.beans.Movie" >
  	 		<constructor-arg type="java.lang.String"  value = "vikram" />
  	 		<constructor-arg type="java.lang.String"  value = "kamal" />
  	 		</bean> 
 ```
 
 ----
##Factory method


 ```  
    <bean id="nvsilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createNonVegSouthIndianLunch"
		factory-bean = "lf" />
			<bean id="vsilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createVegSouthIndianLunch"
		factory-bean = "lf" />
			<bean id="nilunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createNorthIndianLunch"
		factory-bean = "lf" />
			<bean id="chlunch" class="com.chainsys.projectA.beans.Lunch" factory-method = 	"createChineseLunch"
		factory-bean = "lf" />
	</beans>
 ```

## LifeCycle Methods:
   1. init-method is post object creation.
   2. destroy-method is pre object destruction.

## Init-method

-  init-method = " " this method is executed immediately after the constructor.
-  This method  can be used to setup the object before it is ready for service calls.

## Destroyed -method

- destroy - method is only working with singleton
- destroy - method is executed before garbage collector call
- when an object start init-method runs then it will run destroy-method when set to null.

## InitDesposeBean

Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, decorates and otherwise assembles a prototype object, hands it to the client and then has no further knowledge of that prototype instance. For releasing resources try to implement a custom bean post processor.

## Autowire

# Notes: 
	The Spring framework enables automatic dependency injection. 
	In other words, by declaring all the bean dependencies in a Spring configuration file, Spring 	container can autowire relationships between collaborating beans. 
	This is called Spring bean autowiring.

	Autowiring has the following advantages:
-	 Autowiring can significantly reduce the need to specify properties or constructor arguments. 	(Other mechanisms such as a bean template discussed elsewhere in this chapter are also valuable in 	this regard.)
-	Autowiring can update a configuration as your objects evolve. For example, if you need to add a 	dependency to a class, that dependency can be satisfied automatically without you needing to modify 	the configuration.

-	Thus autowiring can be especially useful during development, without negating the option of 	switching to explicit wiring when the code base becomes more stable
	You can combine autowire behavior with dependency checking, which is performed after autowiring 	completes.
  