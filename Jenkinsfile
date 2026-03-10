pipeline {
    agent any
    environment {
        IMAGE = 'baltig.infn.it:4567/epicscs/epicsmng'
    }
    stages {
        stage('Test epics-base versions') {
            matrix {
                agent {
                    docker { 
                        image '${IMAGE}:${OS}'
                    }
                }
                axes {
                    axis {
                        name "OS"
                        values "ubuntu20.04", "ubuntu22.04", "ubuntu24.04", "almalinux9", "almalinux10"
                    }
                    axis {
                        name "base"
                        values "R7.0.10", "R7.0.9"
                    }
                }
                stages {
                    stage('Test epics-base ${base}') {
                        steps {
                            sh 'install.sh'
                            sh 'printf "%s" "base = ${base}" > epicsmng.conf'
                            sh 'epicsmng makemodules epicsmng.conf'
                        }
                    }
                }
            }
        }
    }
}