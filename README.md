
## Allure TestNG Example

### Getting Started

To generate Allure Report you should perform following steps:

```bash
$ git clone git@github.com:allure-examples/allure-testng-example.git
$ ./mvnw clean test site
```

Report will be generated to `target/site/allure-maven-plugin` folder. To open the report you can use the following command:

```bash
$ ./mvnw io.qameta.allure:allure-maven:serve
```

There is another way of generating the report. The generated report can be opened here "target/site/allure-maven-plugin/index.html". The command to generate the report is the following:

```bash
$ ./mvnw io.qameta.allure:allure-maven:report
```

### Tests selective run (filtering)

This feature works when you are triggering a build from Allure TestOps by selecting seperate test cases (not all in your project).

Allure TestOps agent creates **testplan.json** file  with the list of tests on CI, then the test framework adaptor reads the content and makes the seletion of the tests to be executed.

#### Requirements

Allure framework libraries not earlier than 2.13.9

#### How to check locally

For this particular exapmple we have **testplan.json** with the following content:

```JSON
{ "version": "1.0", "tests": [{ "id": 11111, "selector": "my.company.SimpleTest.simpleTestOne" }] }
```
So, we expect only `simpleTestOne` test to be executed.

##### Steps

In the terminal type the following:
```bash
export ALLURE_TESTPLAN_PATH=testplan.json
# just to check the variable was created 
echo $ALLURE_TESTPLAN_PATH
./mvnw clean test
```

TestNG will execute only one test of the two tests present in this example project.



### More

* [Documentation](https://docs.qameta.io/allure/2.0/)
* [Issue Tracking](https://github.com/allure-framework/allure2/issues?labels=&milestone=&page=1&state=open)
* Gitter chat room: [https://gitter.im/allure-framework/allure-core](https://gitter.im/allure-framework/allure-core)
* StackOverflow tag: [Allure](http://stackoverflow.com/questions/tagged/allure)
