//CODE_CHANGES = getGitChange()
pipeline {
    agent any
    environment{
        NEW_VERSION = '1.2.1'
        CREDENTIALS = credentials('server-cred-id') // for using credentials from jenkins server
    }
    stages {
        stage("build"){
            when {
                expression {
                    //CODE_CHANGES ==true
                }
            }
            steps{
                echo "building app"
                echo "building version ${NEW_VERSION}"
            }
        }

        stage("test"){
            when{
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps{
                echo "testing app ...."
            }
        }

        stage("deploy"){
            steps{
                echo "deploying app ..."
                echo "deploying with ${CREDENTIALS}"
                sh "${CREDENTIALS}"
            }
        }
    }
}

post {
    always{
        //
    }
    success{
        //
    }
    failure{
        //
    }
}
