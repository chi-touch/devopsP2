#!/bin/bash

# Check if JAVA_HOME is set and points to a valid Java installation
if [[ -z "$JAVA_HOME" ]]; then
  echo "Error: JAVA_HOME is not set. Please set it to your Java installation path."
  exit 1
fi

# Variables
PROJECT_DIR=$(pwd)                    # Project directory
TARGET_DIR="$PROJECT_knmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn,,,m,mkknmnmmDIR/target"       # Directory where packaged files are generated
JAR_NAME="demo-0.0.1-SNAPSHOT.jar"                   # Name of the JAR file (replace with your app's name)

# Step 1: Clean previous builds
echo "Cleaning previous builds..."
mvn clean

# Step 2: Run unit tests
echo "Running unit tests..."
mvn test
if [[ $? -ne 0 ]]; then
  echo "Error: Some tests failed. Aborting build."
  exit 1
fi

# Step 3: Compile and package the application
echo "Building and packaging the application..."
mvn package

# Check if the JAR was successfully created
if [[ ! -f "$TARGET_DIR/$JAR_NAME" ]]; then
  echo "Error: Build failed. JAR file not found in target directory."
  exit 1
fi

# Step 4: Run the packaged application
echo "Running the application..."
java -jar "$TARGET_DIR/$JAR_NAME"