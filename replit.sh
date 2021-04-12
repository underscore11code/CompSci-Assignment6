#!/bin/bash

### Replit + Gradle start script for CompSci ###
# Downloads gradle, automatically pulls from configured git remote, and builds + runs.
# Replit, seems like native gradle support wouldn't be very difficult. Do so please!

out () {
  echo "[init] ===================="
  echo "[init] $1"
  echo "[init] ===================="
}

out "Pulling Latest Code"
git pull
chmod +x ./gradlew
out "Building"
./gradlew build
out "Done. Running."
./gradlew --console=plain -q run
