Aufgabe 1:

a)
First, main difference about un-/checked exceptions and an error:
Checked Exceptions require the developer to handle an exception which might occur.
Unchecked Exceptions (Subs of RuntimeExceptions) don't have to be catched (but result in exit).
Errors on the other hand are related to the JVM, which occure due to abnormal behaviour

1: IndexOutOfRangeException, Unchecked Exception, because there is no element at index 5. Actually no element at all :^}
	# You could... add 6 elements :)
	Anyways, accessing the element directly after initializing the list seems, not useful
	# So, usually you would have a list already layin around and you could check with an if against the list.Count()
	
2: IMO it's an checked Exception, under the condition that "createNewFile()" actually performs an IO-Operation
	-> java.io.IOException
	Yet, it also reasonable that there is a "more serious" issue, makin the JVM throw an
	-> java.io.IOError
	So, since the third problem is an error, it's safe to assume this was meant to be an checked Exceptions
	# We can either place an try catch around it and handle the situation in the catch
	# But it would actually depend on the situation and the exact exception thrown
	
3: Since an infite loop doesn't throw an exception at all, there will eventually be thrown an error
	but otherwise, the program will run and run and run forever
	# We will have to rewrite our loop, either replace "true" or have to break/continue inside the loop
	
b)
look into the code

c)
do it again

d)
######
OUTPUT:
######
Some other exception: null
Ex1 or Ex4
Ex2 or Ex5
Ex1 or Ex4
Ex2 or Ex5
FATAL ERROR!
######

In my companies software we can import pointclouds given a list of points.
Now, a user can trigger the Method OpenPointCloudImportDialog(), where he has to choose an pointcloud-file.
This method will then start the import-process and can eventually fail
	(ie. no permission to open the file, the data is corrupt, data could not be written into database, whatever)
In any situation, these exceptions get thrown somewhere deep down in the source-code in the actual modules, packages, ...

So, a couple of different modules have to participate in the process of import - when one of these fails, the specific
method throws the exception, which will be chained up to the OpenPointCloudImportDialog() - which takes all the possible
Exceptions and prints an unified Message: "Import PointCloud failed."
Additionally, the user will have the possibility to click on the exception and get a more
detailed information - the inner exception, that was chained up. (Like "PointCloud is corrupt")