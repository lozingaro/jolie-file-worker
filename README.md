# Jolie File Worker

*File Worker* is a Java Service to split in chunks in file and unsplit a file rejoining it (no matter the extension). The Java Service is correlated with a [Jolie interface](.test/file_worker.iol) (`.test/file_worker.iol`) and a test service (`./test/file_worker_test.ol`) to embed the File Worker Service  and use it in Jolie projects.

## Getting Started

A very few things to get started with the project, depending if you want to use the Jolie service (main reason why to be here), or, alternatively, use the Java Service for other scopes. In both cases I suggest to follow the **Running the tool** section below.

### Prerequisities

- Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
- Jolie 1.7.1 (C) 2006-2019 the Jolie team
- Apache Maven 3.6.0

## Running the tool

1. Follow the instructions at this page [to build properly a Java Service for Jolie](https://jolielang.gitbook.io/docs/technology-integration/javaservices).
2. In case you want to modify the Java Service, open it in your favourite IDE (e.g. NetBeans) and work on it as a Maven project.
3. Use the `jar` file produced from the *build* Maven process and place it in the `test/lib` folder.
4. Run `jolie file_worker_test.ol` into a shell to test it.

## Built With

* [Java](https://openjdk.java.net/) - The Programming Language used for to build the Java Service;
* [Jolie](https://www.jolie-lang.org/) - The Programming Language used to build the Interface for the file worker service.
* [Apache Maven](https://maven.apache.org/) - The Software project managemente to pack up Java dependencies and build the jar.

## Contributing

Please read [CONTRIBUTING](CONTRIBUTING.md) for details on our code of conduct,
and the process for submitting pull requests to us.

## Authors

* **PhD Student Stefano Pio Zingaro** [@szingaro](https://github.com/szingaro) - *Code and Maintenance* - [WebSite](http://cs.unibo.it/~stefanopio.zingaro)

## License

This project is licensed under the GNU v.3 License - see the [LICENSE](LICENSE) file for details.
