# Scala concepts code


1. Run the project running `sbt ~run` in the app source root directory. The ~ is optional and causes sbt to re-run on every file save allowing to a rapid development workflow.

You can run sbt via Docker wuthout installing it via the provided Dockerfile. Running this will give you a command line with sbt, and your source code, `docker build -t sbt-cli-a . && docker run -it -v $(pwd):/opt/app -w /opt/app  sbt-cli-a`

1. See `Main.scala` for all the code.
