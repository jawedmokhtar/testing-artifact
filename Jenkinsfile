pipeline {
    agent any
    tools {
        maven 'maven'
        // jdk 'jdk8'
    }
    stages {
        stage ('Test mavn'){
            steps {
                sh "mvn test"
                sh "mvn test -P SeleniumTests"
            }
        }
        stage('Test seleniumm') {
            steps {
                sh "mvn test -P SeleniumTests"
            }
        }
        stage('cucumber') {
            steps {
                sh "npm install"
                sh "./node_modules/.bin/wdio --suite login"
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}