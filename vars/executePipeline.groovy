def call(String name = 'test') {
    pipeline {
        agent any


        stages {
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
                    }
                }
            }
        }
    }
}

