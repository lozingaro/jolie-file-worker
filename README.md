# Jolie File Worker

*File Worker* is a Java Service to split in chunks in file and unsplit a file rejoining it (no matter the extension). The Java Service is correlated with a [Jolie interface](.test/file_worker.iol) (`.test/file_worker.iol`) and a test service (`./test/file_worker_test.ol`) to embed the File Worker Service  and use it in Jolie projects.

## Getting Started


### Prerequisities

- Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
- Jolie 1.7.1 (C) 2006-2019 the Jolie team
- Apache Maven 3.6.0

## Running the tool

0. Please follow the instructions at this page [to build properly a Java Service for Jolie](https://jolielang.gitbook.io/docs/technology-integration/javaservices)
1. In case you want to modify the Java Service, open it in your favourite IDE and work on it as a Maven project.
2. Use the `jar` file produced from the *build* Maven process and place it in the `test/lib` folder.
3. Run `jolie file_worker_test.ol` into a shell to test it.

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

This project is licensed under the GNU v.3 License - see the [LICENSE](LICENSE) file for details

## Acknowledgements

The students, members of the group that developed the first tool version:
* [vsalvo](https://github.com/vsalvo);
* [AlessandroCordella](https://github.com/AlessandroCordella);
* [lateganto](https://github.com/lateganto).
