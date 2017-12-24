package com.hcl.ingbootcamp.javatc.volatiles;

import net.jcip.annotations.ThreadSafe;

/** @author masud
 *
 *
 *
 *
 *This is an example of volatile bean pattern
 *
 *Conditions:
 *	1.	all the data members of the JavaBean are volatile, and the getters and setters must be trivial -- they must contain no logic other than getting or setting the appropriate property.
 *	2.	for data members that are object references, the referred-to objects must be effectively immutable.
 *	3.	As with any volatile variable, there may be no invariants or constraints involving the properties of the JavaBean.
 *	
 *
 */
@ThreadSafe
public class Person {
    private volatile String firstName;
    private volatile String lastName;
    private volatile int age;
 
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
 
    public void setFirstName(String firstName) { 
        this.firstName = firstName;
    }
 
    public void setLastName(String lastName) { 
        this.lastName = lastName;
    }
 
    public void setAge(int age) { 
        this.age = age;
    }
}