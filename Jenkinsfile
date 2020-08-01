pipeline {
    agent any

    stages {
        stage('Print message') {
            steps {
                echo "${BRANCH}"
            }
        }
        stage('Run test') {
            steps {
                withMaven(jdk: 'java_13', maven: 'maven_3.6.3') {
                    bat 'mvn test -Dcucumber.filter.tags="@checkCredit" -Dmaven.test.failure.ignore-true'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        report: 'target/allure-report',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}