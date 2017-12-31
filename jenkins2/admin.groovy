#!groovy

import jenkins.model.*;
import hudson.security.*;
import jenkins.install.*;
import hudson.triggers.SCMTrigger;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition
import hudson.plugins.git.GitSCM
import hudson.plugins.git.*;


def instance = Jenkins.getInstance()

println "-->creating local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin', 'admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()

instance.setAuthorizationStrategy(strategy)
instance.save()

jenkins = Jenkins.instance;
gitTrigger = new SCMTrigger("* * * * *");

workflowJob = new WorkflowJob(jenkins, "workflow-dev");

jobNameDev = "dev";
dslProjectDev = new hudson.model.FreeStyleProject(jenkins, jobNameDev);
dslProjectDev.addTrigger(gitTrigger);
jenkins.add(dslProjectDev, jobNameDev);

jobNameStg = "stg";
dslProjectStg = new hudson.model.FreeStyleProject(jenkins, jobNameStg);
dslProjectStg.addTrigger(gitTrigger);
jenkins.add(dslProjectStg, jobNameStg);

jobNamePrd = "prd";
dslProjectPrd = new hudson.model.FreeStyleProject(jenkins, jobNamePrd);
dslProjectPrd.addTrigger(gitTrigger);
jenkins.add(dslProjectPrd, jobNamePrd);


jobDev = jenkins.getItem(jobNameDev);
builders = jobDev.getBuildersList();

hudson.tasks.Shell newShell = new hudson.tasks.Shell("echo \"Hello\" ")
builders.replace(newShell)


def scm = new GitSCM("https://github.com/kfengbest/docker2.git")
scm.branches = [new BranchSpec("*/master")];
def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")
def parent = Jenkins.instance
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, "my-pipeline")
job.definition = flowDefinition
parent.reload()





gitTrigger.start(dslProjectDev, true);




