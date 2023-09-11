def call() {
    pipeline {
        agent any

        stages {
            stage('Get Versions to deploy') {
                steps {
                    script {
                        env.VERSION = input message: 'Specify Version',
                                        parameters: [choice(name: 'VERSION', choices: step_getVersions(), description: 'Select Version')]
                    }
                }
            }
        }
    }
}

