#!/bin/bash
cd "$(dirname "$0")"
exec java -jar jetty-runner.jar warmup.war