# How To #
JDataPath will let you query special paths that the OS may support. Supported path types:
  * local data, ideal for storing your application data
  * profile
It may be extended with "video path", "music path" etc.

Only **Windows** have a special implementation (through native code). Other OSes uses a default implementation (uses system properties). Other native implementations are welcome :)

## Install ##
  * Download and unpack the files to your project.
  * Set native lib path system property.
  * Include the jar in your classpath.

For example, on windows OSes, start java with this argument:
```
java -Djava.library.path=lib/native/windows -cp lib/jdatapath.jar ...
```

Of course, the target path must contain the native library for your OS.

## Java Agent Usage (fix 'user.home') ##

Start your java application with these vm params:
  * -Djava.library.path=<path to native libs>
  * -javaagent:<path to jdatapath.jar>

For example:
```
java -javaagent:lib/jdatapath.jar -Djava.library.path=lib/native/windows -cp lib/myapp.jar MyAppMain
```

JDataPath will output to the console (System.err) about the fix result. For example:
> JDataPath: OK Assigned 'user.home': C:\Users\MyUser

## Code Usage ##

Using JDataPath is simple. Here is an example:

```
DataPath localDataPath = JDataPathSystem.getLocalSystem().getLocalDataPath(wantedDirName);
System.out.println("My local path: " + localDataPath.getPath());
System.out.println("Is path recommended by OS: " + localDataPath.isRecommendedByOs());

DataPath profilePath = JDataPathSystem.getLocalSystem().getUserProfilePath();
System.out.println("Profile path: " + profilePath);
```

The returned path object tells if it is recommended by the OS. When **isRecommendedByOs()** is false, it means that the OS does not have any special location for the requested path.