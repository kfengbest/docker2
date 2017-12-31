FROM jenkins/jenkins:lts

USER root

RUN /usr/local/bin/install-plugins.sh git github workflow-aggregator pipeline-stage-view mailer

COPY ./jobs/dev/config.xml /var/jenkins_home/jobs/dev/config.xml
COPY ./jobs/staging/config.xml /var/jenkins_home/jobs/stg/config.xml
COPY ./jobs/prd/config.xml /var/jenkins_home/jobs/prd/config.xml

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

