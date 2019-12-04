This project invloves most of the things present in Junit 5
This Project is based on the youtube videos by JavaBrains

Junit is used for unit testing 

platform
 -jupiter -- junit 5
 -vintage -- older things
 -ext -- custom testing methods

junit testing can be done by creating test classes in test package 

Assertions is class which includes lot of methods to test the expected vs actual

assertEquals is used to check whether the expectation is equal to actual

other similar methods are assertArrayEquals and assertIterableEquals

there are lot of methods available in the assertion package like assertFalse which checks whether condition passed is false. these assertion import is a static import

assertThrows is function which fails the test if the expected exception doesn't throw

Junit has lifecycle hook which provides intialization before each methos or the entire class and teardown after all methods or the entire class. these hooks can be accessd with help of annotations.

these annotations are @BeforeAll, @AfterAll, @BeforeEach, @AfterEach

BeforeAll and AfterAll methods must be static since the methods should be run before initializing. static methods needs no instance variables.

TestInstance is another way of controlling the initialization of classes by using annotation @TestInstance. in this annotation, by mention PER_CLASS, PER_METHOD we can customize the usage

@DisplayName - used to give custom name to the test
@Disabled - Skip the test while running the test class used for test driven devolopment

Conditional Excecution
 -@EnabledOnOs(OS.LINUX)
 -@EnabledOnJre(JRE.JAVA_11)
 -@EnabledIf
 -@EnabledIfSystemProperty
 -@EnabledIfEnvironmentVariable

in conditional execution when the condition is not met the test method get skipped 

assumptions can be done by importing static assumptions package.eg functions in assumptions is assumeTrue(boolean) which disables the test when the assumption is not true

@Nested is used to nest put multiple methods inside a subclass

we can use assertAll(Collection<Executable> Executable) instead of using nested 

when you are using a expensive string for showing message when the test fails, use lambda to make it efficient

@Repeated Test(n) is used to repeat the test n no. of times
you can also get hold of each repetition of test by passing argument(RepetitionInfo repetitionInfo) from that argument you can now avail methods like getCurrentRepetition() and getTotalRepetition() from this you can validate each repetition with each other or more

you can selectively run the tests by tagging them specific name by @Tag annotation
with this you can specifically run tests not all of them

TestInfo and TestReporter are two Interfaces which can be used to get the testInfo and modify it 




