# Use the Jenkins LTS base image
FROM jenkins/jenkins:lts

# Switch to root to install tools
USER root

# Install dependencies
RUN apt-get update && apt-get install -y \
    wget unzip git openjdk-17-jdk

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Install Android SDK command line tools
ENV ANDROID_SDK_ROOT=/opt/android-sdk

RUN mkdir -p $ANDROID_SDK_ROOT/cmdline-tools \
 && cd $ANDROID_SDK_ROOT/cmdline-tools \
 && wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O tools.zip \
 && unzip tools.zip \
 && rm tools.zip \
 && mv cmdline-tools latest

ENV PATH=$PATH:$ANDROID_SDK_ROOT/latest/bin:$ANDROID_SDK_ROOT/platform-tools

# Accept SDK licenses
RUN yes | $ANDROID_SDK_ROOT/latest/bin/sdkmanager --licenses

# Install Android SDK components
RUN $ANDROID_SDK_ROOT/latest/bin/sdkmanager \
    "platform-tools" \
    "platforms;android-34" \
    "build-tools;34.0.0"

# Switch back to Jenkins user
USER jenkins
