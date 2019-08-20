
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

### More

* [Documentation](https://docs.qameta.io/allure/2.0/)
* [Issue Tracking](https://github.com/allure-framework/allure2/issues?labels=&milestone=&page=1&state=open)
* Gitter chat room: [https://gitter.im/allure-framework/allure-core](https://gitter.im/allure-framework/allure-core)
* StackOverflow tag: [Allure](http://stackoverflow.com/questions/tagged/allure)
