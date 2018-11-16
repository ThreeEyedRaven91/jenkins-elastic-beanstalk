# jenkins-elastic-beanstalk

Jenkins library provide quick method to deploy application to Elastic Beanstalk

## Installation and use
### Add to Jenkins

Go to `Manage Jenkins` => `Configure System` => `Global Pipeline Libraries
` => Press `Add`

Fill the following information:

| Information        | Value                                                         |
|--------------------|---------------------------------------------------------------|
| Name               | elastic-beanstalk                                             |
| Default version    | master                                                        |
| Retrieval method   | Modern SCM                                                    |
| Project Repository | git@github.com:ThreeEyedRaven91/jenkins-elastic-beanstalk.git |
| Credentials        | none                                                          |

### Add to Jenkins file

Top of Jenkins file

```
@Library('elastic-beanstalk') _
```

Use inside the steps

```
steps {
    script {
        terEB.deploy(
            application: "<eb application>",
            env: "<eb environment>",
            keyName: "<ec2 key name>",
            platform: "<platform>",
            region: "<region>",
            profile: "<profile>"
        )
    }
}
```

### How to get those input

1. Profile: Not any solution yet. You should input it in `.aws/config` by yourself in jenkins server :(
2. Other params: I usually run `eb init` manually first, then copy the data here.