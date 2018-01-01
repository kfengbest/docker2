FROM jenkins/jenkins:lts

USER root
RUN /usr/local/bin/install-plugins.sh workflow-aggregator job-dsl git mailer pipeline-model-definition aws-credentials s3 pipeline-aws
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
COPY admin_user.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY create_job_pipeline.groovy /usr/share/jenkins/ref/init.groovy.d/
#COPY add_credential_aws.groovy /usr/share/jenkins/ref/init.groovy.d/

