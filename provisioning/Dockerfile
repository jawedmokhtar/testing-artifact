FROM ubuntu:16.04

RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install curl wget apt-utils gcc make build-essential sudo bzip2 unzip git apt-transport-https
RUN apt-get install -y python
RUN apt-get install -y python3-pip

RUN pip3 install pexpect

RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main" | sudo tee -a /etc/apt/sources.list
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -

RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
# RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
RUN wget -q -O - https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -

RUN curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -

RUN apt-get update
RUN apt-get -y install nodejs yarn default-jre

RUN wget http://chromedriver.storage.googleapis.com/2.27/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip
RUN cp ./chromedriver /usr/bin/chromedriver
RUN chmod ugo+rwx /usr/bin/chromedriver

RUN apt-get -y install libxpm4 libxrender1 libgtk2.0-0 libnss3 libgconf-2-4

RUN apt-get -y install google-chrome-stable

RUN apt-get -y install xvfb gtk2-engines-pixbuf

RUN apt-get -y install xfonts-cyrillic xfonts-100dpi xfonts-75dpi xfonts-base xfonts-scalable

RUN apt-get -y install imagemagick x11-apps

RUN echo "Starting X virtual framebuffer (Xvfb) in background..."
RUN Xvfb -ac :0 -screen 0 1280x1024x16 &
RUN export DISPLAY=:0

# This is in accordance to : https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04
RUN apt-get update && \
	apt-get install -y openjdk-8-jdk && \
	rm -rf /var/cache/oracle-jdk8-installer;

# Fix certificate issues, found as of
# https://bugs.launchpad.net/ubuntu/+source/ca-certificates-java/+bug/983302
RUN apt-get update && \
	apt-get install -y ca-certificates-java && \
	update-ca-certificates -f && \
	rm -rf /var/cache/oracle-jdk8-installer;

# Setup JAVA_HOME, this is useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

RUN npm install -g nightwatch

#RUN apt-get -y install maven
# Install npm packages
WORKDIR /testingArtifact/IntegrationTests
RUN npm install
RUN echo "npm packages:"
WORKDIR /

ENV MAVEN_VERSION=3.5.0
ENV MAVEN_HOME=/opt/mvn
ENV PATH=$PATH:/testingArtifact/IntegrationTests/node_modules/phantomjs-prebuilt/bin

# change to tmp folder
WORKDIR /tmp

# Download and extract maven to opt folder
RUN wget --no-check-certificate --no-cookies http://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && wget --no-check-certificate --no-cookies http://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz.md5 \
    && echo "$(cat apache-maven-${MAVEN_VERSION}-bin.tar.gz.md5) apache-maven-${MAVEN_VERSION}-bin.tar.gz" | md5sum -c \
    && tar -zvxf apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt/ \
    && ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/mvn \
    && rm -f apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && rm -f apache-maven-${MAVEN_VERSION}-bin.tar.gz.md5

# add executables to path
RUN update-alternatives --install "/usr/bin/mvn" "mvn" "/opt/mvn/bin/mvn" 1 && \
    update-alternatives --set "mvn" "/opt/mvn/bin/mvn"

# make jenkins repository
RUN mkdir -p /home/jenkins/.m2/repository
RUN chmod -R 777 /home/jenkins

WORKDIR /
#COPY entryPoint.sh.pending /entryPoint.sh.pending
#COPY functions.sh.pending /functions.sh.pending
#ENTRYPOINT bash /entryPoint.sh.pending


