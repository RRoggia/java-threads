# java-threads
Content is based on:
* [Oracle tutorial Thread](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) [Inprogress]
* Java Cookbook - chapter 22 - Thread Java [Todo]
* Java Network Programming - Chapter 3 - Threads [Todo]
* Java Performance - The definitive guide - Chapter 9 - Thread and Synchronization performance [Todo]
* Java Pocket Guide - Chapter 14 - Concurrency [Todo]
* Java Threads [Todo]
* Learning Java - Chapter 9 - Threads [Todo]

## Concurrency
The ability to do more than one thing at the same time.

The Java platform is designed from the ground up to support concurrent programming, with basic concurrency support in the Java programming language and the Java class libraries.

## Main Thread and Processes
When you run a java application, it will start a *main thread*. The main thread is created inside a process - and every process will have at least one thread.

Processes will have their own resources in the OS, for example their private memory space.

By default, the JVM will create not only the *main thread* but also other threads for internal usage, for example garbage collector, signal handling and so on...

It's often use the term *lightweight processes* to refer to threads, because creating a thread requires less resources than creating a process. Because the thread share the process' resource, by killing a process you'll kill its threads.

### Exercise 1 - Monitoring Threads
1. Open the JVisualVM. It's a monitoring tool that comes together with your JDK. You'll find it in the `bin/` folder of the JDK.
2. Create a new Java Project.
3. Create a `ProcessThread` class and implement the `static void main(String args[])` method.
	* Create a loop without end to ensure the process will never stop.
4. Run your java application.
5. Find the process id (pid) of your application.
6. In your OS, look for the resources being used by the process.


## Defining Threads
Each thread is associated with an instance of the `Thread` class. There are two ways of implementing concurrent behavior in java:

### Implements Runnable
When your class is only interested to provide the concurrent behavior. It should implement the `Runnable` interface. And provide an instance of your class when creating the `Thread` instance.

### Extends Thread
When your class is not only interested to provide the concurrent behavior, but also override some other `Thread`'s behavior. It should extend the `Thread` class. Keep in mind java does not allow multiple inheritance, therefore, you won't be able to extends other classes.

### Starting a thread
Both examples invoke the `start` method from the `Thread` class in order to start the new thread.

### Exercise 2 - Creating Threads concurrently
In the *main thread* instantiate and start two new threads.

* First Thread: 
	* The class must inherit from the `HelloWorld` class and use the `hello` method to print *hello world* **concurrently**.
* Second Thread:
	* The class print the `Thread` information using the `getId` and `getName` methods.  

## Thread's Lifecycle and States 
A thread will always have a state assigned to it. A JVM thread can assume only one state at time. Check the `Thread.State` enum in order to see the available states. You can also check the [Thread.State javadoc](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html).

### start()
Begins the execution of the thread. The JVM invokes thread's `run()` method.

### interrupt()
An interrupt is an indication to a thread that it should stop what it is doing and do something else. It's up to the programmer to decide exactly how a thread responds to an interrupt, but it is very common for the thread to terminate. A thread can check if it was interrupted by calling the `Thread.interrupted()` method, or by catching the `InterruptedException` thrown by the `Thread` methods.

### join()
Causes the current thread to pause its execution until a specified thread terminates its execution.

### Thread.sleep()
Suspends thread execution during a specified period.

### Thread.currentThread()
Returns a reference to the currently executing thread object.

### Thread.interrupted()
Returns whether the thread was interrupted or not. Clears the thread's interrupted status. 

### Exercise 3 - Interrupting a thread 
In the *main thread* instantiate and start a new thread. The new thread should sleep for 10 minutes. Again in the *main thread* interrupt the sleep execution after 1 minute. Print in the console the following events:

	* Thread is created
	* Thread is started
	* Thread is interrupted 
	* Before thread is going to sleep
	* When the thread execution is interrupted
	* After thread wakes up

### Exercise 4 - Interrupting a thread
In the *main thread* instantiate and start a new thread. The new thread should run for a undetermined time (**IT SHOULD NOT GO TO SLEEP**). Print in the console the following events:

	* Thread is created
	* Thread is started
	* Thread is interrupted
	* When it started its execution
	* When it was interrupted

### Exercise 5 - Interrupting a thread
In the *main thread* instantiate and start two new threads. 

* First Thread:
	* Start its execution, sleep for 20000ms and then finish its execution
* Second Thread
	* Start its execution, and then wait to thread one to finish its execution. Then finish its own execution
* In the *main thread* after you started both threads, wait 100 ms and print thread one and two state.

## Synchronization
Threads communicate primarily by sharing access to fields and the objects reference fields refer to. This form of communication is extremely efficient, but makes two kinds of errors possible: *thread interference* and *memory consistency* errors. The tool needed to prevent these errors is synchronization.

### Thread interference & Memory Consistency Error
* **Interference** happens when two operations, running in different threads, but acting on the same data, interleave.
* **Memory consistency errors** occur when different threads have inconsistent views of what should be the same data.

The `Counter` class is shared with several threads. The `increment` and `decrement` methods do the following steps:
1. Retrieve the current value of `c`.
2. Store in the `start` Map the thread id and the value of `c`.
2. Increment the value of `c` by 1.
3. Store the incremented value back in `c`.
4. Store in the `finish` Map the thread id and the value of `c`.

What **we would expect** is that each thread retrieves the state of the c field adds 1 and updates c value. Something like the output below:

```console
Thread 10 started with 0
Thread 10 finished with 1
Thread 11 started with 3
Thread 11 finished with 4
Thread 12 started with 2
Thread 12 finished with 3
Thread 13 started with 1
Thread 13 finished with 2
```

In the console above, each thread is only incrementing the value of c by one. But if we execute the code in the `InterferenceExample` class, what we have is:

```console
Thread 10 started with 0
Thread 10 finished with 1
Thread 11 started with 0
Thread 11 finished with 2
Thread 12 started with 1
Thread 12 finished with 3
...
```

This execution depicts the thread interference and the memory consistency error, its implementation is most likely as following:

* Thread 10 starts Counter.c has 0
* Thread 11 starts Counter.c has 0
* Thread 10 stores Counter.c to the start map
* Thread 11 stores Counter.c to to the start map
* Thread 10 increments Counter.c by 1. **c = 1**.  
* Thread 10 stores Counter.c to the finish map
* Thread 12 starts Counter.c has 1
* Thread 12 stores Counter.c to the start map
* Thread 11 increments Counter.c by 1. **c = 2**.
* Thread 11 stores Counters.c to the finish map
* Thread 12 increments Counter.c by 1. **c = 3**.
* Thread 12 stores Counter.c to the finish map

Because the programmer cannot ensure that one method execution happened before another one, it's possible to have an inconsistency in the expected state of the `c` value. In addition, The code is also interleaving. Thread interference bugs can be difficult to detect and fix. This sort of behavior happens not only in the java code itself, but also after the java code was transformed into JVM code (example: `c++` and `c--`.

### Happens Before relationship & Synchronized
This relationship is simply a guarantee that memory writes by one specific statement are visible to another specific statement. There are several actions that create happens-before relationships. One of them is synchronization, as we will see in the following sections.

#### Synchronized methods
In order to finish the error above is quite easy, you can make usage of the `synchronized` keyword. Example `public synchronized void increment`

Once you do that, it is not possible for two invocations of synchronized methods on the same object to interleave. When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object.

Synchronization is built around an internal entity known as the intrinsic lock or monitor lock.  Intrinsic locks enforces exclusive access to an object's state and establishes happens-before relationships that are essential to visibility.

Every object has an intrinsic lock associated with it.

When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object and releases it when the method returns. The lock release occurs even if the return was caused by an uncaught exception.

#### Synchronized statement
Unlike synchronized methods, synchronized statements must specify the object that provides the intrinsic lock.

Synchronized statements are also useful for improving concurrency with fine-grained synchronization. 


 
 

