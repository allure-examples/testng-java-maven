[phantomjs]: http://phantomjs.org/download.html
[maven]: http://maven.apache.org/
[git]: http://git-scm.com/
[allure-commandline]: https://docs.qameta.io/allure/latest/#_installing_a_commandline

## Allure TestNG Example

### Getting Started

To run tests you need to install [allure-commandline][allure-commandline], [maven][maven], [git][git] and [phantomjs][phantomjs].

To generate Allure Report you should perform following steps:

```bash
$ git clone git@github.com:allure-examples/allure-testng-example.git
$ mvn clean test
$ mvn site
```

To see a report, run `allure open target/site/allure-maven-plugin/`

**NOTE: required maven version 3.1.1 or above**

### More

* [Documentation](https://docs.qameta.io/allure/latest/#_testng)
* [Issue Tracking](https://github.com/allure-framework/allure-java/issues)
* Mailing list: [allure@yandex-team.ru](mailto:allure@qameta.io)
* Gitter chat room: [https://gitter.im/allure-framework/allure-core](https://gitter.im/allure-framework/allure-core)
* StackOverflow tag: [Allure](http://stackoverflow.com/questions/tagged/allure)
