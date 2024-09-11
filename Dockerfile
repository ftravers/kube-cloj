# Base image
FROM clojure:openjdk-17-tools-deps-bullseye

# Create a directory for the application
WORKDIR /app

# Copy deps.edn and source code
COPY deps.edn /app/
COPY src /app/src

# Install dependencies by caching them first
RUN clj -P

# Specify the main class or file to run (replace with your app's entry point)
CMD ["clj", "-m", "clj-dok.core"]