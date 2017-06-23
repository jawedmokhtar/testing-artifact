pipeline {
    agent any
    //tools {
     //   maven 'maven'
       // nodejs 'Node 7.2'
        // jdk 'jdk8'
   // }
    stages {
        stage('npm installation') {
            steps {
                sh """
                    env | grep HOSTNAME
                    echo $PATH
                    node --version
                    npm --version
                """
            }
        }
        stage('cucumber') {
            steps {
                sh """
                    cd IntegrationTests/
                    npm install
                    ./node_modules/.bin/wdio --suite login
                """
            }
        }
        stage ('Test mavn'){
            steps {
                sh "mvn test"
                sh "mvn test -P functionalTests"
            }
        }
        stage('Test seleniumm') {
            steps {
                sh "mvn test -P SeleniumTests"
            }
        }
        stage('bruteForce testing') {
            steps {
                sh """
                    cd penetration_testing
                    python bruteForceOpenzip.py -f locked.zip -d dictionary.txt
               """
            }
        }
        stage('bruteForce Site testing') {
            steps {
                sh(returnStdout: true, script: """
                    cd penetration_testing
                    python3 bruteForceSite.py -H http://automationpractice.com/index.php?controller=authentication -u jmores047@gmail.com -F dictionary.txt
                """)
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