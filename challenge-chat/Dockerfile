FROM buildpack-deps:jessie

# verify gpg and sha256: http://nodejs.org/dist/v0.10.31/SHASUMS256.txt.asc
# gpg: aka "Timothy J Fontaine (Work) <tj.fontaine@joyent.com>"
# gpg: aka "Julien Gilli <jgilli@fastmail.fm>"
RUN gpg --keyserver pool.sks-keyservers.net --recv-keys 7937DFD2AB06298B2293C3187D33FF9D0246406D 114F43EE0176B71C7BC219DD50A3051F888C628D

ENV NODE_VERSION 0.10.38
ENV NPM_VERSION 2.11.1

RUN curl -SLO "http://nodejs.org/dist/v$NODE_VERSION/node-v$NODE_VERSION-linux-x64.tar.gz" \
	&& curl -SLO "http://nodejs.org/dist/v$NODE_VERSION/SHASUMS256.txt.asc" \
	&& gpg --verify SHASUMS256.txt.asc \
	&& grep " node-v$NODE_VERSION-linux-x64.tar.gz\$" SHASUMS256.txt.asc | sha256sum -c - \
	&& tar -xzf "node-v$NODE_VERSION-linux-x64.tar.gz" -C /usr/local --strip-components=1 \
	&& rm "node-v$NODE_VERSION-linux-x64.tar.gz" SHASUMS256.txt.asc \
	&& npm install -g npm@"$NPM_VERSION" \
	&& npm cache clear

ADD bin /home/challenge-chat/bin
ADD public /home/challenge-chat/public
ADD node_modules /home/challenge-chat/node_modules
ADD routes /home/challenge-chat/routes
ADD spec /home/challenge-chat/spec
ADD views /home/challenge-chat/views
ADD app.js /home/challenge-chat/app.js
ADD constants.js /home/challenge-chat/constants.js
ADD gruntFile.js /home/challenge-chat/gruntFile.js
ADD package.json /home/challenge-chat/package.json
ADD run.sh home/challenge-chat/run.sh

EXPOSE 3000

RUN chmod 777 /home/challenge-chat/run.sh

ENTRYPOINT /home/challenge-chat/run.sh