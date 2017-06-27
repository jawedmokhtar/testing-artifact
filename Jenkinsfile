pipeline {
    agent any
    stages {
        stage('cucumber tests') {
            steps {
                dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                        cd IntegrationTests/
                        npm install
                        ./node_modules/.bin/wdio --suite login
                    """
                }
            }
        }
        stage ('Test maven functional'){
            steps {
                dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                        mvn test
                        mvn test -P functionalTests
                    """
                }
            }
        }
        stage ('Test maven selenium'){
            steps {
                dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                       mvn test -P SeleniumTests
                    """
                }
            }
        }
        stage('bruteForce testing') {
             steps {
                 dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                      cd penetration_testing
                      python bruteForceOpenzip.py -f locked.zip -d dictionary.txt
                    """
                }
             }
        }
        stage('bruteForce Site testing') {
            steps {
                dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                        cd penetration_testing
                        python3 bruteForceSite.py -H http://automationpractice.com/index.php?controller=authentication -u jmores047@gmail.com -F dictionary.txt
                    """
                }
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