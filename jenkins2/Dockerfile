FROM jenkins/jenkins:lts

USER root
RUN /usr/local/bin/install-plugins.sh workflow-aggregator job-dsl git mailer
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
COPY admin_user.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY create_job_pipeline.groovy /usr/share/jenkins/ref/init.groovy.d/

