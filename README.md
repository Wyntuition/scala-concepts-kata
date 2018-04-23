# Scala concepts code


1. Run the project running `sbt ~run` in the app source root directory. The ~ is optional and causes sbt to re-run on every file save allowing to a rapid development workflow.

    You can run sbt via Docker wuthout installing it via the provided Dockerfile. Running this will give you a command line with sbt, and your source code, `docker build -t sbt-cli-a . && docker run -it -v $(pwd):/opt/app -w /opt/app  sbt-cli-a`

    You can also run `docker-compose run app` to get a shell and then `./sbt ~run`.

1. See `Main.scala` for kata code.



- Code Scala basics
- Code concepts:
  - 
- Add Play
- Run local workfloow
- Deploy