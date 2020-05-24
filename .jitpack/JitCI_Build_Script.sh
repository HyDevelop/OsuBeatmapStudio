#!/usr/bin/env bash

# Copy and paste this under the Git additional commands area
alias gradle='./gradlew'
rm -rf ./gradlew
mv ./.jitpack/gradlew_unmodified ./gradlew
chmod +x gradlew
mv ./.jitpack ./gradle
