# KANOAm2 

KANOAm2 (tasK specifications And heterogeNeous rObot teAms, a Multoi-Model approach) is a tool-supported approach for the generation of task plans. We provide a user-friendly DSL for the adoption of KANOAm2. We use EclipseEMF Modeling Tools, project execution environment 'JavaSE-11'.


## 1 Xtext (DSL code) Set up in Eclipse

***DSL code is provided in Resources>Source>1 DSL Generation***

To use Quartet, you must have installed EMF and SDK (already installed for EMF). It can be installed via Help>Install New Software> Work with: 2022-09 - http://download.eclipse.org/releases/2022-09/ [or your Eclipse verison downaload page] > Modelling > Select EMF - Eclipse Modeling Framework SDK and the Ecore Diagram Editor (SDK).

Install the plugins Xtext and Xtend (Help> Eclipse Marketplace).

(Instructions to upload the DSL code into Eclipse are similar to: https://github.com/Gricel-lee/Quartet-MRS-DSL/blob/main/README.md)


### 1.1 Create Ecore model

Create a new Empty EMF project.

![image](https://user-images.githubusercontent.com/63869574/157302815-76010dfd-5cc3-4748-8a54-599e32c91b28.png)

Project name: se.gu.uoy.dsl > Finish

Right click on model folder and create a new Ecore Model:

![image](https://user-images.githubusercontent.com/63869574/157302954-64ee4b16-b2e1-4cc2-ad83-f8cd034a3cb5.png)

![image](https://user-images.githubusercontent.com/63869574/157302995-35c49c86-dd84-427c-b213-3ef4b93f1a59.png)

File name: quantitativePatterns.ecore > Finish

![image](https://user-images.githubusercontent.com/63869574/157303148-d87b5443-1f5c-48d6-a9f7-ca6b67a7c945.png)

Replace this file with the one provided here in Github.

Right click on the Ecore Model and create a new EMF Generator Model> Next > Next > Ecore model > Select the Ecore File and click Load > Next > Finish

![image](https://user-images.githubusercontent.com/63869574/157303557-c53455a1-9242-43f8-93ce-e0fbebc55e20.png)

![image](https://user-images.githubusercontent.com/63869574/229150387-c6d72305-4262-47c5-a3f6-21d99f823354.jpeg)

![image](https://user-images.githubusercontent.com/63869574/157303629-c46f8f66-a32a-4e94-a911-956a7dfb0e36.png)

![image](https://user-images.githubusercontent.com/63869574/157303651-3ffd446b-2b8b-4c2a-9bae-269c15bfb300.png)

![image](https://user-images.githubusercontent.com/63869574/157303676-8369f471-cfd5-418e-ad95-660df05fdb02.png)

This should create the .genmodel. Right click at the root of the .genmodel and select Generate All.

![image](https://user-images.githubusercontent.com/63869574/157303738-2fc08257-0cf5-47e5-870c-a1571508725b.png)

It should have created edit, editor and tests folders:

![image](https://user-images.githubusercontent.com/63869574/157303770-a5cae357-5b30-4dd0-9d98-a9c67297117c.png)

Right click on each of the folders (plugins) and click Configure > Convert to Xtext Project

![image](https://user-images.githubusercontent.com/63869574/157303845-8cd6cb9f-80db-42c2-ad7e-1d932fd38e97.png)

### 1.2 Create Xtext model

Go to File > New > Other > Xtext > Xtext Project From Existing Ecore Models > Add the .genmodel and select **ProblemSpecification as Entry rule** > Next > Finish
(Make sure ProblemSpecifications is the entry rule or it would create a different root for the model).

![image](https://user-images.githubusercontent.com/63869574/157304022-08fef1ad-3a43-4f4f-aabd-13ee6c6224ef.png)

![Screenshot 2023-03-29 at 11 52 54](https://user-images.githubusercontent.com/63869574/228511867-6f5aa0f8-0f42-439e-bb4f-8dc8f93a7c7f.jpg)


It should generate 4 new plugins:

![image](https://user-images.githubusercontent.com/63869574/157304117-8c0b7fd3-b38c-4126-b9e8-8cc52e0ddc05.png)

Replace only the org.xtext.example.mydsl folder with the one provided here in Github. 

Ignore errors for now and run ```org.xtext.example.mydsl/GenerateMyDsl.mwe2```. Then run ```org.xtext.example.mydsl/MyDsl.xtext```.
Change ```var path_sigAlloyDeclaration``` in MyDslGenerator.xtend to your own directory path.

Ready to go!


- (**ERROR1.** If replacing causes problems, try replacing the content in mydsl/MyDsl.xtext (```org.xtext.example.mydsl/src/org/xtext/example/mydsl/MyDsl.xtext```), then right click> Run as> 1 Generate Xtext Artifacts. Three new subfolder must appear: .formatting2, .generator, .scoping and .validation. Go to the second, example.mydsl.generator (```org.xtext.example.mydsl/src/org/xtext/example/mydsl/generator/MyDslGenerator.xtend```), and copy the 3 .txt files. Finally replace MyDslGenerator.xtend in the same folder.)
- (**ERROR2.** If an error appears in **Files.readString** it may be because of using JavaSE<11. Go to Project Properties > Java Build Path> Libraries > Add Library > JRE System Library > Execution environment> JavaSE-11(jdk19) )

### 1.3 Run example

Right click on the .xtext file on the src folder (of the first plugin) > Run As > 1 Generate Xtext artifacts (```org.xtext.example.mydsl/src/org/xtext/example/mydsl/MyDsl.xtext```)

Right click on the .mwe2 file on the src folder (of the first plugin) > Run As > MWE2 (```org.xtext.example.mydsl/src/org/xtext/example/mydsl/GenerateMyDsl.mwe2```):

![image](https://user-images.githubusercontent.com/63869574/228543118-6880cc02-5a48-4547-8277-79f3015264fd.jpeg)

Right click on the first folder (org.xtext.example.mydsl) > Run as > Run Configuration > Eclipse Application > Launch Runtime Eclipse

Now you can create a new project, create a new file with extension .mydls, and when saved, it automatically generates files

### Note
Note: Sometimes the project needs to be refreshed or cleaned to get the output file:

<img width="193" alt="Screenshot 2022-07-12 at 16 03 08" src="https://user-images.githubusercontent.com/63869574/178522451-ca18c2bb-c6de-42a7-b5d7-f6b3de2bf7a7.png">


- (**ERROR3.** ```Can't load library: /Users/.../.swt/lib/macosx/aarch64/libswt-cocoa-4954r7.jnilib``` This error is detected in Mac M1 processor. For our application, changing Run Configuration of our Eclipse Application setup to run on Java J2SE-1.4 (JRE[17.0.5]) helped. This problem is with the processor outside the scope of this project.
![image](https://github.com/Gricel-lee/Kanoa/assets/63869574/be039c0a-512d-4559-96a0-7e5a9503a2d0)


## 2 Task Allcoation and Scheduling
We tested Kanoam2 on Eclipse IDE Version: 2022-06 (4.24.0), project execution environment 'JavaSE-1.8' (JRE[17.0.2]).


***Task allocation code is provided in Resources>Source>2 TaskAllocatorScheduler***

It was developed as a Maven project. Make sure that the following Libraries are uploaded as part the pom.xml file:
![Screenshot 2022-08-03 at 01 53 11](https://user-images.githubusercontent.com/63869574/182501198-00b894b8-d11c-48a2-91cf-33b5a827c4e7.png)

Make sure you add the environmental variable in __Run Conconfigurations__, on IOs:
- DYLD_LIBRARY_PATH = libs/runtime

on Linux:
- LD_LIBRARY_PATH = libs/runtime

and on Windows:
- add in the environmental variable PATH the path to the libs/runtime folder on your project
- add in Build Path > Libraries > JRE Sys Lib > Native library location > ***External folder*** > "C:/...your path Kanoa-main/uoy.mrs/libs/runtime"

![image](https://user-images.githubusercontent.com/63869574/196206022-52ea3e08-5843-469d-9582-095b53421aaf.png)


You can now run ```RunApp.java``` directly or from your own project.

