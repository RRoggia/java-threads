# java-threads

## Concurency
The ability to do more than one thing at the same time.

The Java platform is designed from the ground up to support concurrent programming, with basic concurrency support in the Java programming language and the Java class libraries.

## Main Thread and Processes
When you run a java application, it will start a *main thread*. The main thread is created inside a process - and every process will have at least one thread.

Processes will have their own resources in the OS, for example their private memory space.

By default, the JVM will create not only the *main thread* but also other threads for internal usage, for example garbage collector, signal handling and so on...

It's often use the term *lightweight processes* to refer to threads, because creating a thread requires less resources than creating a process. Because the thread share the process' resource, by killing a process you'll kill its threads.

### Exercise 1 - Monitoring Threads
1 - Open the JVisualVM. It's a monitoring tool that comes together with your JDK. You'll find it in the `bin/` folder of the JDK.
2 - Create a new Java Project.
3 - Create a `ProcessThread` class and implement the `static void main(String args[])` method.
	* Create a loop without end to ensure the process will never stop.
4 - Run your java application.
5 - Find the process id (pid) of your application.
6 - In your OS, look for the resources being used by the process.
 
 

