pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Packaging'){
            steps {
                sh "git archive -v -o artifect.zip --format=zip HEAD"
            }
        }
        stage('Upload to S3') {
            steps {
                withAWS(region:"us-east-1",credentials:"glb_usr_n_p") {
                    s3Upload(file:"artifect.zip", bucket:"cp-docker2-stg-s3-eb",path:"artifect.zip")
                }
            }
        }
    }
}
