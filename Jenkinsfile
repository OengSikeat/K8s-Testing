pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test --no-daemon'
            }
        }

        stage('Approve') {
            options { timeout(time: 1, unit: 'HOURS') }
            steps {
                script {
                    def decision = input(
                        message: "Build #${env.BUILD_NUMBER} passed. Approve?",
                        ok: "Submit",
                        submitter: "alice,bob",
                        parameters: [
                            choice(name: 'DECISION',
                                   choices: ['Approve', 'Reject'],
                                   description: 'Approve or reject this build')
                        ]
                    )
                    if (decision != 'Approve') {
                        currentBuild.result = 'FAILURE'
                        error("Build rejected by approver.")
                    }
                    echo "Approved — build #${env.BUILD_NUMBER}."
                }
            }
        }

    }

    post {
        success {
            echo "Build #${env.BUILD_NUMBER} built and approved."
        }
        failure {
            echo "Build failed or was rejected — check console output."
        }
        aborted {
            echo "Approval was cancelled or timed out."
        }
    }
}