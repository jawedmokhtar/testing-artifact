FROM ubuntu:16.04

RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install curl wget apt-utils gcc make build-essential sudo bzip2 unzip git apt-transport-https

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

RUN apt-get -y install maven
RUN api-get -y install


