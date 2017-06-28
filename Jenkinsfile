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
                      cd performanceTests/gatling
                      /opt/gatling/bin/gatling.sh -nr -sf ${pwd} -s computerdatabase.advanced.AdvancedSimulationStep01
                      #/opt/gatling/bin/gatling.sh -nr -s computerdatabase.advanced.AdvancedSimulationStep02
                      #/opt/gatling/bin/gatling.sh -nr -s computerdatabase.advanced.AdvancedSimulationStep03
                      #/opt/gatling/bin/gatling.sh -nr -s computerdatabase.advanced.AdvancedSimulationStep04
                      mkdir ../results/reports
                      mv results/advancedsimulationstep01*/simulation.log results/reports/01.log
                      #mv ../results/advancedsimulationstep02*/simulation.log ../results/reports/02.log
                      #mv ../results/advancedsimulationstep03*/simulation.log ../results/reports/03.log
                      #mv ../results/advancedsimulationstep04*/simulation.log ../results/reports/04.log
                      /opt/gatling/bin/gatling.sh -ro ${pwd}/reports
                      publishHTML("performanceTests/gatling-charts-highcharts-bundle-2.2.5/results/reports/index.html")
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