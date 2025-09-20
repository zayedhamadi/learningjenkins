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
