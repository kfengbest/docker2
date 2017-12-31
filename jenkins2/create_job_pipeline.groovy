#!groovy
import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import hudson.security.*
import hudson.tools.*
import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition
import hudson.plugins.git.GitSCM
import java.util.logging.Logger
import hudson.plugins.git.*;
import hudson.triggers.SCMTrigger

def dev_pipeline_job = "dev"
def stg_pipeline_job = "stg"
def prd_pipeline_job = "prd"
def pipeline_repo = "https://github.com/kfengbest/docker2.git"
def pipeline_file = "Jenkinsfile"

def userRemoteConfig = new UserRemoteConfig(pipeline_repo, null, null, null)
def scmTrigger = new SCMTrigger('* * * * *')

def scmDev = new GitSCM(
    Collections.singletonList(userRemoteConfig),
    Collections.singletonList(new BranchSpec("*/master")),
    false,
    Collections.<SubmoduleConfig>emptyList(),
    null,
    null,
    null)
WorkflowJob jobDev = Jenkins.instance.createProject(WorkflowJob, dev_pipeline_job);
def definitionDev = new CpsScmFlowDefinition(scmDev,pipeline_file)
definitionDev.lightweight = true
jobDev.definition=definitionDev
jobDev.addTrigger(scmTrigger)
jobDev.save()


def scmStg = new GitSCM(
    Collections.singletonList(userRemoteConfig),
    Collections.singletonList(new BranchSpec("*/staging")),
    false,
    Collections.<SubmoduleConfig>emptyList(),
    null,
    null,
    null)
WorkflowJob jobStg = Jenkins.instance.createProject(WorkflowJob, stg_pipeline_job);
def definitionStg = new CpsScmFlowDefinition(scmStg,pipeline_file)
definitionStg.lightweight = true
jobStg.definition=definitionStg
jobStg.addTrigger(scmTrigger)
jobStg.save()


def scmPrd = new GitSCM(
    Collections.singletonList(userRemoteConfig),
    Collections.singletonList(new BranchSpec("*/prd")),
    false,
    Collections.<SubmoduleConfig>emptyList(),
    null,
    null,
    null)
WorkflowJob jobPrd = Jenkins.instance.createProject(WorkflowJob, prd_pipeline_job);
def definitionPrd = new CpsScmFlowDefinition(scmPrd,pipeline_file)
definitionPrd.lightweight = true
jobPrd.definition=definitionPrd
jobPrd.addTrigger(scmTrigger)
jobPrd.save()


Jenkins.instance.reload()



