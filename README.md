# Filter-Emails-From-Files
Software required: JDK,IDE Java language(Netbeans,IntelliJ,...)
A program that aims to filter all Emails contained in .txt files that are scrambled and contain many unwanted elements
## There will be 2 cases

**Case 1**
- You replace the content of the input.txt file

**Case 2**

- You want to locate to an existing file on your computer
  - Step 1: Locate to the file location on your hard drive.
For example, if your file is located in the path D:\Data\email.txt
  - Step 2: you just need to replace the line `String outputFile = " src/source/output.txt";`
change into
`String outputFile = " D:\\Data\\email.txt";`
