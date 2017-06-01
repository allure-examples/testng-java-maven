pipeline {
    agent { label 'java' }
    stages {
        stage('Build') {
            steps {
                sh './mvnw -Dmaven.test.failure.ignore=true clean verify site'
            }
        }
         stage('Report') {
                    steps {
                        publishHTML([reportName  : 'Allure Report', reportDir: 'target/site/allure-maven-plugin', reportFiles: 'index.html',
                                     reportTitles: '', allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false])
                    }
                }
    }
    post {
        always {
            deleteDir()
        }
        failure {
            slackSend message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} failed (<${env.BUILD_URL}|Open>)",
                    color: 'danger', teamDomain: 'qameta', channel: 'allure', tokenCredentialId: 'allure-channel'
        }
    }
}