#!/bin/bash

set -e

echo "Cleaning..."
lein clean

echo "Calculating version..."
REVISION=`git --no-replace-objects describe --tags --match v0.0`
# Extract the version number from the string. Do this in two steps so
# it is a little easier to understand.
REVISION=${REVISION:5} # drop the first 5 characters
REVISION=${REVISION:0:${#REVISION}-9} # drop the last 9 characters

prefix=0.1
suffix=$REVISION
version=$prefix.$suffix
echo $version

echo "Change in project..."
lein set-version $version

echo "Tagging..."
git tag -a v${version} -m "Release ${version}"
git push origin v${version}

echo "Release done!"
