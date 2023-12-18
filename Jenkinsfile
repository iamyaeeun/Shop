node {
    def app
    def PROJECT_ID = 'opensource-398212'
    def CLUSTER_NAME = 'kube'
    def LOCATION = 'asia-northeast3-a'
    def CREDENTIALS_ID = 'bb429487-8eb3-4417-84a5-2d23f10f81cf'
    
    stage('Clone repository') {
        git 'https://github.com/iamyaeeun/Shop.git'
    }
    stage('Build image') {
        app = docker.build("hyaeeun/opensource:${env.BUILD_ID}")
    }
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'hyaeeun') {
           app.push("${env.BUILD_NUMBER}")
           app.push("latest")
        }
    }
    stage('Deploy to GKE') {
        if (env.BRANCH_NAME == 'master') {
            // Replace image tag in deployment.yaml with the current build ID
            script {
            sh "sed -i 's/hyaeeun\\/opensource:latest/hyaeeun\\/opensource:\${env.BUILD_ID}/g' deployment.yml"
            }

            // Deploy to GKE using KubernetesEngineBuilder
            step([$class: 'KubernetesEngineBuilder', 
                  projectId: PROJECT_ID, 
                  clusterName: CLUSTER_NAME, 
                  location: LOCATION, 
                  manifestPattern: 'deployment.yml', 
                  credentialsId: CREDENTIALS_ID, 
                  verifyDeployments: true])
        }
    }
}
