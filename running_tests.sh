#!/bin/bash

BROWSER=""
BROWSER_VERSION=""
REMOTE_URL=""

# shellcheck disable=SC1081
while [ "$#" -gt 0 ];
do

  case $1 in
    --remote)
      REMOTE_URL=$2
      shift
      ;;
    --browser)
      BROWSER=$2
      shift
      ;;
    --browser_version)
      BROWSER_VERSION=$2
      shift
      ;;
    *)
      echo "Argument $1 not supported"
      exit 1
  esac
  shift

done


echo "Running UI tests on selenoid via maven"
mvn clean test -Dbrowser=$BROWSER -Dbrowser.version=$BROWSER_VERSION -Dremote.url=$REMOTE_URL