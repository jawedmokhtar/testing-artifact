pipeline {
    agent any
    DISABLE_AUTH = 'true'
    DB_ENGINE    = 'sqlite
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
                    cd IntegrationTests/
                    npm install
                    cd ../
                    mvn test -P SeleniumTests
                    """
                }
            }
        }
        stage('Performance testing') {
            steps {
                dockerNode(image: "jawedm/automation-jenkins") {
                    git "https://github.com/jawedmokhtar/testing-artifact"
                    sh """
                    /opt/gatling/bin/gatling.sh -nr -rf \${PWD}/performanceTests/gatling/results -sf \${PWD}/performanceTests/gatling -s computerdatabase.advanced.AdvancedSimulationStep01
                    mkdir -p performanceTests/gatling/results/reports
                    ls -la performanceTests/gatling/results/
                    mv performanceTests/gatling/results/advancedsimulationstep01*/simulation.log performanceTests/gatling/results/reports/01.log
                    /opt/gatling/bin/gatling.sh -ro \${PWD}/performanceTests/gatling/results/reports
                    """
                publishHTML (target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'performanceTests/gatling/results/reports',
                    reportFiles: 'index.html',
                    reportName: "Automation Tests Report"
                    ])
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
                      ls -la
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
                        pwd
                        ls -la
                        python3 --version
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