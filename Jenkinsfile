pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/zayedhamadi/learningjenkins'
        GIT_BRANCH = 'main'
        DOCKER_IMAGE = "testapp:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${GIT_BRANCH}", url: "${GIT_URL}"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker rm -f testapp_container || true
                docker run -d -p 8081:8081 --name testapp_container ${DOCKER_IMAGE}
                '''
            }
        }
    }

    post {
        always {
            echo "Pipeline terminé."
        }
        failure {
            echo "Le pipeline a échoué ❌"
        }
        success {
            echo "Pipeline exécuté avec succès ✅"
        }
    }
}
