def call(String name = 'test') {
    pipeline {
        agent any


        stages {
            stage ("Import Libraries") {
                script {
                    library identifier: 'another-jenkins-test'
                }
            }
            stage ("Starting") {
                steps {
                    script {
                        echo "Starting"
                    }
                }
            }
            stage('Get Versions to deploy') {
                steps {
                    script {
                        env.VERSION = input message: 'Specify Version',
                                        parameters: [choice(name: 'VERSION', choices: step_getVersions("Jason"), description: 'Select Version')]
                        echo "env.VERSION: ${env.VERSION}"
                        env.values = fetchValues()
                        echo "VALUES: ${env.values}"
                    }
                }
            }
        }
    }
}

